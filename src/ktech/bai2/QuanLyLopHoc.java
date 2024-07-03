package ktech.bai2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyLopHoc {


    public static void main(String[] args) {

        // khởi tạo store để lưu dữ liệu, sẽ có danh sách lớp và học viên, khởi tạo list rỗng.
        Database db = new Database();
        // Hoc Vien dữ liệu tĩnh implement
        HocVienImplement.themHocVienTinh(db);
        // Lop Hoc lớp học dữ liệu tĩnh implement
        LopHocImplement.taoLopHocTinh(db);
        // Giao Vien , them giao vien tĩnh
        GiaoVien.addGiaoVienTinh(db);
        // In ra danh sách học sinh
        HocVienImplement.inRaDanhSachHocVien(db);
        System.out.println("===============");
        // in ra danh sách lớp
        LopHocImplement.inRaDanhSachLop(db);
        System.out.println("===============");
        // in ra danh sách giáo viên
        GiaoVien.inDanhSachGiaoVien(db);

        // Đăng ký học viên vào lớp.
        tuDongDangKyHocVienVaoLopHoc(db);

        // In ra danh sách
        HocVienImplement.inRaDanhSachHocVien(db);
        LopHocImplement.inRaDanhSachLop(db);

        // Kiểm tra lớp vừa thêm học viên đã đủ điều kiện bắt đầu chưa.
        if(!kiemTraLopDaDuDieuKienDeBatDau(db.getListLopHoc().get(1))) {
            System.out.println("Lớp vừa thêm học viên chưa đủ số học viên để bắt đầu");
        } else {
            choLopHocBatDau(db.getListLopHoc().get(1), db);
            System.out.println("Lớp vừa thêm học viên đủ số học viên để bắt đầu");
        }
        // Đăng ký cho giáo viên vào dạy lớp học.
        dangKyGiaoVienVaoLop(db.getListGiaoVien().get(1),db.getListLopHoc().get(1));

        // In ra danh sách
        HocVienImplement.inRaDanhSachHocVien(db);
        LopHocImplement.inRaDanhSachLop(db);
        GiaoVien.inDanhSachGiaoVien(db);

        // Học sinh bỏ học.
        hocVienBoHoc( db.getListHocVien().get(4) ,"Do việc gia đình", db);

        // in danh sách học sinh bỏ học.
        System.out.println("Danh sách học viên bỏ học");
        HocVienImplement.inRaDanhSachHocVienBoHoc(db);

        // IN ra danh sach học viên mà giáo viên đang dạy ở các lớp.
        System.out.println("\n Danh sách học viên của giáo viên");
        db.getListGiaoVien().get(1).inRaDanhSachHocVienDangDay(db);

    }

    // đăng ký Học viên vào Lớp học
    static void dangKyHocVienVaoLop(HocVien hv, LopHoc lh) {
        if(hv.getTuoiHocSinh() < 18) {
            System.out.println("Học Viên chưa đủ tuổi để đăng ký học");
            return;
        }

        // check xem có đăng ký lh này chưa.
        for(String maLopHoc: hv.getListLopHocDangThamGia()) {
            if(maLopHoc.equals(lh.getMaLopHoc())) {
                System.out.println("Học viên đã đăng ký lớp này r");
                return;
            }
        }

        // Check số lượng học viên hiện có trong lớp , nếu đủ 10 sẽ không cho đk.
        if(lh.getListHocVien().size() >= 10) {
            System.out.println("Lớp đã đủ số lương, học viên không thể đăng ký");
            return;
        }

        // Check xem học viên có đang bỏ học không, nếu có thì không cho học, cần set cho học lại mới đc đăng ký.
        if(hv.getTinhTrangHoc().equals(String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.BO_HOC))) {
            System.out.println("Học viên đã bỏ học, không thể đăng ký lớp.");
        }


        hv.setTinhTrangHoc(String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.DA_DANG_KY));
        hv.setMaHocVien(hv.getcCCD() + "-" + ((int) (Math.random() * 100)));
        hv.dangKyLopHoc(lh.getMaLopHoc());
        lh.addHocVienVaoLopHoc(hv.getMaHocVien());
    }

    // kiểm tra xem Lớp đã đủ điều kiện số lượng học viên để bắt đầu chưa.
    static boolean kiemTraLopDaDuDieuKienDeBatDau(LopHoc lh) {
        return lh.getListHocVien().size() == 10;
    }

    // Set cho lớp học bắt đầu, cập nhật ngày giờ nhập học và trạng thái.
    static void choLopHocBatDau(LopHoc lh, Database db) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyy");
        DateTimeFormatter dfTime = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        String dateStr = nowDate.format(df);
        String timeStr = nowTime.format(dfTime);

        // Thời điểm hiện tại.
        String dateTimeStr = dateStr + " " + timeStr;

        for(String maHV: lh.getListHocVien()) {
            HocVien hv = db.getHocVienTuMaHV(maHV);
            if(hv == null) continue;
            hv.setNgayGioNhapHoc(dateTimeStr);
            hv.setTinhTrangHoc(String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.DANG_HOC));
        }

        lh.setNgayGioNhapHoc(dateTimeStr);
        lh.setTinhTrangLopHoc(String.valueOf(Constanst.TINH_TRANG_LOP_HOC.DANG_DIEN_RA));

    }

    // Đăng ký giáo viên vào lớp học
    static void dangKyGiaoVienVaoLop(GiaoVien gv, LopHoc lh) {
        // Kiểm tra xem giao viên có đang dạy lớp này chưa;
        for(String maGV: lh.getListGiaoVienDangDay()) {
            if(gv.getMaGiaoVien().equals(maGV)) {
                System.out.println("Giáo viên đã được đăng ký dạy lớp này!");
                return;
            }
        }

        // kiểm tra xem gv đag dạy bao nhiêu lớp
        if(gv.getListLopDangDay().size() >= 2) {
            System.out.println("Giáo viên: " + gv.getTenGiaoVien() +
                    " hiện đã dạy 2 lớp, không thể dạy thêm lớp khác!");
            return;
        }

        lh.themGiaoVienVaoLopHoc(gv.getMaGiaoVien());

        gv.dangKyLopChoGiaoVien(lh.getMaLopHoc());
        System.out.println("Đăng ký thành công");
    }

    // Set cho học viên nào bỏ học.
    static void hocVienBoHoc(HocVien hv, String liDo, Database db) {

        // xóa mã học sinh trong cách lớp học
        for(String maLopHoc: hv.getListLopHocDangThamGia()) {
            LopHoc lh = db.getLopHocTuMaLopHoc(maLopHoc);
            if(lh == null) continue;
            lh.xoaHocVienTuMaHV(hv.getMaHocVien());
        }

        // xóa các lớp học của học sinh đag tham gia, set lí do nghỉ học, set lại tình trạng học
        hv.thoatCacLopHocDangThamGia();
        hv.setMaHocVien("");
        hv.setLiDoNghiHoc(liDo);
        hv.setTinhTrangHoc(String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.BO_HOC));
    }

    // Set cho học viên nghỉ học quay lại đăng ký
    static void choHocVienDKLai(HocVien hv, Database db) {
        hv.setTinhTrangHoc(String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.CHUA_DK));
    }

    // Tự động đăng ký học viên vào lớp học
    private static void tuDongDangKyHocVienVaoLopHoc(Database db) {
        int sizeHocVien = db.getListHocVien().size();
        int sizeLopHoc = db.getListLopHoc().size();

        dangKyHocVienVaoLop(db.getListHocVien().get(1), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(2), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(3), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(4), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(5), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(6), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(7), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(8), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(9), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(10), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(11), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(12), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(13), db.getListLopHoc().get(1));
        dangKyHocVienVaoLop(db.getListHocVien().get(14), db.getListLopHoc().get(1));
    }

    // Sửa thông tin học viên
    private static void suaThongTinHocVien(String cCCD, String tenMoi, String ngaySinhMoi, String cCCDMoi, Database db) {
        HocVien hv = db.getHocVienTuCCCD(cCCD);
        if(hv == null) {
            System.out.println("Học viên cần sửa thông tin không tồn tại");
            return;
        }

        if(tenMoi != null) {
            hv.setTenHocSinh(tenMoi);
        }

        if(ngaySinhMoi != null) {
            hv.setNgaySinh(ngaySinhMoi);
        }

        if(cCCDMoi != null) {
            hv.setcCCD(cCCDMoi);
        }


    }

    // in menu chính
    private static void inMenuChinh(Scanner sc) {
        System.out.println("Quản lý lớp học.");
        System.out.println("1.Tạo dữ liệu có sẵn.");
        System.out.println("2.Tự nhập bằng tay.");
        System.out.println("0.Để thoát.");



    }

}
