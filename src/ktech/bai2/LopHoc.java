package ktech.bai2;

import java.util.ArrayList;

public class LopHoc {
    private String maLopHoc;
    private String tenLopHoc;
    private String tinhTrangLopHoc;
    private ArrayList<String> listHocVien;  // lưu string của lop hoc.
    private final int soHocVienToiDaTrongLop = 10; // số học viên tối da trong lớp.
    private String ngayGioNhapHoc;
    private ArrayList<String> listGiaoVienDangDay;


    // cho mỗi bàn có 2 học viên.
    LopHoc(String tenLopHoc, String maLopHoc) {
        this.tenLopHoc = tenLopHoc;
        this.maLopHoc = maLopHoc;
        this.listHocVien = new ArrayList<>();
        this.listGiaoVienDangDay = new ArrayList<>();
        this.tinhTrangLopHoc = String.valueOf(Constanst.TINH_TRANG_LOP_HOC.CHUA_BAT_DAU);

    }

    public void xoaHocVienTuMaHV(String maHV) {
        int indexMaHV = this.listHocVien.indexOf(maHV);

        if(indexMaHV == -1) {
            System.out.println("Lớp học không có học viên này");
            return;
        }

        this.listHocVien.remove(indexMaHV);

    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public ArrayList<String> getListHocVien() {
        return listHocVien;
    }

    public void setListHocVien(ArrayList<String> listHocVien) {
        this.listHocVien = listHocVien;
    }

    public void addHocVienVaoLopHoc(String maHV) {
        this.listHocVien.add(maHV);
    }

    public String getNgayGioNhapHoc() {
        return ngayGioNhapHoc;
    }

    public void setNgayGioNhapHoc(String ngayGioNhapHoc) {
        this.ngayGioNhapHoc = ngayGioNhapHoc;
    }

    public String getTinhTrangLopHoc() {
        return tinhTrangLopHoc;
    }

    public void setTinhTrangLopHoc(String tinhTrangLopHoc) {
        this.tinhTrangLopHoc = tinhTrangLopHoc;
    }

    public ArrayList<String> getListGiaoVienDangDay() {
        return listGiaoVienDangDay;
    }

    public void setListGiaoVienDangDay(ArrayList<String> listGiaoVienDangDay) {
        this.listGiaoVienDangDay = listGiaoVienDangDay;
    }

    public void themGiaoVienVaoLopHoc(String maGV) {
        this.listGiaoVienDangDay.add(maGV);
    }
}
