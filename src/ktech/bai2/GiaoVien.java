package ktech.bai2;

import java.util.ArrayList;

public class GiaoVien {
    private String tenGiaoVien;
    private String maGiaoVien;
    private ArrayList<String> listLopDangDay; // lưu id của các lớp.

    GiaoVien(String tenGiaoVien, String maGiaoVien ) {
        this.tenGiaoVien = tenGiaoVien;
        this.maGiaoVien = maGiaoVien;
        this.listLopDangDay = new ArrayList<>();
    }

    public static void addGiaoVienTinh(Database db) {
        GiaoVien gv1 = new GiaoVien("Giao vien 1", "gc-01");
        GiaoVien gv2 = new GiaoVien("Giao vien 2", "gc-02");
        GiaoVien gv3 = new GiaoVien("Giao vien 3", "gc-03");
        db.addGiaoVien(gv1);
        db.addGiaoVien(gv2);
        db.addGiaoVien(gv3);
    }

    public static void inDanhSachGiaoVien(Database db) {
        for(GiaoVien gv:  db.getListGiaoVien()) {
            System.out.println("Tên giáo viên: " + gv.getTenGiaoVien() +
                    " | Mã giáo viên: " + gv.getMaGiaoVien() +
                    " | Các Lớp Đang Dạy: " + gv.getListLopDangDay() );
        };
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public ArrayList<String> getListLopDangDay() {
        return listLopDangDay;
    }

    public void setListLopDangDay(ArrayList<String> listLopDangDay) {
        this.listLopDangDay = listLopDangDay;
    }

    public void dangKyLopChoGiaoVien(String maLopHoc) {
        this.listLopDangDay.add(maLopHoc);
    }

    public void inRaDanhSachHocVienDangDay(Database db) {
        for(String maLop: this.listLopDangDay) {
            LopHoc lh = db.getLopHocTuMaLopHoc(maLop);
            if(lh == null) continue;
            System.out.println("Danh sách học sinh trong lớp: " + lh.getTenLopHoc());
            HocVienImplement.inRaThongtinHocVien(maLop, db);
        }
    }
}
