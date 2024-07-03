package ktech.bai2;

import java.util.ArrayList;

public class HocVienImplement {

    // Hàm tạo dữ liệu học viên tĩnh
    static void themHocVienTinh(Database db) {

        String[] listTenHocVien = {"hoc sinh 1", "hoc sinh 2", "hoc sinh 3", "hoc sinh 4", "hoc sinh 5", "hoc sinh 6",
                                    "hoc sinh 7", "hoc sinh 8", "hoc sinh 9", "hoc sinh 10","hoc sinh 11", "hoc sinh 12", "hoc sinh 13",
                                    "hoc sinh 14", "hoc sinh 15", "hoc sinh 16", "hoc sinh 17", "hoc sinh 18", "hoc sinh 19", "hoc sinh 20",};
        String[] listNgaySinh = {"07/08/2000", "12/06/2007", "10/08/2010", "01/10/2001", "11/12/1999", "01/08/1997",
                                "02/03/2004", "07/02/2005", "03/11/2002", "11/10/2003", "01/05/1998", "15/09/2009", "12/02/2011",
                                "09/12/2001", "01/11/1998", "20/08/1996", "24/05/2000", "18/10/2002", "29/04/2003", "04/03/2004",};
        String[] listCCCD = {"123410", "123411", "123412", "123413", "123414", "123415",
                "123416", "123417", "123418", "123419", "123420", "123421", "123422",
                "123423", "123424", "123425", "123426", "123427", "123428", "123429",};

        for(int i = 0; i < listTenHocVien.length; i++) {
            themHocVien(listTenHocVien[i], listNgaySinh[i], listCCCD[i], db);
        }
    }

    // Hàm them học viên
    static void themHocVien(String tenHocSinh, String ngaySinh, String cCCD, Database db) {
        // Kiểm tra học viên có trùng cCCD không.
        for(HocVien hv: db.getListHocVien()) {
            if(hv.getcCCD().equals(cCCD)) {
                System.out.println("Học viên này đã được đăng ký với CCCD: " + cCCD + " .Bạn hãy check lại");
                return;
            }
        }
        HocVien hv = new HocVien(tenHocSinh, ngaySinh, cCCD);
        db.addHocVien(hv);
    };

    // Hàm in thông tin chung cho học viên
    private static void inThongTin(HocVien hv) {
        System.out.println("Tên học viên: " + hv.getTenHocSinh() +
                " | mã học viên: " + hv.getMaHocVien() +
                " | CCCD: " + hv.getcCCD() +
                " | Tuổi: " + hv.getTuoiHocSinh() +
                " | Tình trạng học: " + hv.getTinhTrangHoc() +
                " | Danh sách lớp đang học: " + hv.getListLopHocDangThamGia());
    }

    // in ra danh sách toàn bộ học viên
    static void inRaDanhSachHocVien(Database db) {
        for(HocVien hv:  db.getListHocVien()) {
            inThongTin(hv);
        }
    }

    // In ra danh sách học viên bỏ học.
    static void inRaDanhSachHocVienBoHoc(Database db) {
        System.out.println();
        for(HocVien hv:  db.getListHocVien()) {
            if(!hv.getTinhTrangHoc().equals(String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.BO_HOC))) continue;
            inThongTin(hv);
        }
    }

    // In ra thông tin học viên đang học tại lớp , theo mã lớp học.
    static void inRaThongtinHocVien(String maLopHoc, Database db) {
        for(HocVien hv: db.getListHocVien()) {
            if(!hv.getListLopHocDangThamGia().contains(maLopHoc)) continue;
            inThongTin(hv);
        }

    }

}
