package ktech.bai2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HocVien {
    private String tenHocSinh;
    private String ngaySinh;
    private String cCCD;
    private String maHocVien;
    private String tinhTrangHoc; // 'CHUA_DK', 'DANG_HOC', 'BO_HOC', 'HOAN_THANH'
    private String liDoNghiHoc;
    private String ngayGioNhapHoc;
    private ArrayList<String> listLopHocDangThamGia; // lưu id lớp đang tham gia\\
    private int tuoiHocSinh;

    HocVien(String tenHocSinh, String ngaySinh, String cCCD) {
        this.tenHocSinh = tenHocSinh;
        this.ngaySinh = ngaySinh;
        this.cCCD = cCCD;
        this.listLopHocDangThamGia = new ArrayList<>();
        this.maHocVien = "";
        this.tinhTrangHoc = String.valueOf(Constanst.TINH_TRANG_HOC_VIEN.CHUA_DK);
        this.tinhTuoiHocSinh();
    }

    private void tinhTuoiHocSinh() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaySinhDate = LocalDate.parse(this.ngaySinh, df);
        LocalDate today = LocalDate.now();

        int tuoi = today.getYear() - ngaySinhDate.getYear();

        this.tuoiHocSinh = tuoi;

    }


    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public String getNgaySinh() {
        return this.ngaySinh;
    }

    public  void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
        this.tinhTuoiHocSinh();
    }


    public String getcCCD() {
        return cCCD;
    }

    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    public String getMaHocVien() {
        return maHocVien.isEmpty() ? "Chưa có mã học viên" : maHocVien;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHocVien = maHocVien;
    }

    public String getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(String tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public String getLiDoNghiHoc() {
        return liDoNghiHoc;
    }

    public void setLiDoNghiHoc(String liDoNghiHoc) {
        this.liDoNghiHoc = liDoNghiHoc;
    }

    public String getNgayGioNhapHoc() {
        return ngayGioNhapHoc;
    }

    public void setNgayGioNhapHoc(String ngayGioNhapHoc) {
        this.ngayGioNhapHoc = ngayGioNhapHoc;
    }

    public ArrayList<String> getListLopHocDangThamGia() {
        return listLopHocDangThamGia;
    }

    public void setListLopHocDangThamGia(ArrayList<String> listLopHocDangThamGia) {
        this.listLopHocDangThamGia = listLopHocDangThamGia;
    }

    public void thoatCacLopHocDangThamGia() {
        this.listLopHocDangThamGia.clear();
    }

    public void dangKyLopHoc(String maLopHoc) {
        this.listLopHocDangThamGia.add(maLopHoc);
    }

    public int getTuoiHocSinh() {
        return tuoiHocSinh;
    }
}
