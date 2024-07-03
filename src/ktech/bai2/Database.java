package ktech.bai2;

import java.util.ArrayList;

public class Database {
    private ArrayList<HocVien> listHocVien;
    private ArrayList<GiaoVien> listGiaoVien;
    private ArrayList<LopHoc> listLopHoc;

    Database() {
        listHocVien = new ArrayList<>();
        listLopHoc = new ArrayList<>();
        listGiaoVien = new ArrayList<>();
    }

    public HocVien getHocVienTuCCCD(String cCCD) {
        for(HocVien hv: this.getListHocVien()) {
            if(hv.getcCCD().equals(cCCD)) return hv;
        }
        return null;
    }

    public HocVien getHocVienTuMaHV(String maHV) {
        for(HocVien hv: this.getListHocVien()) {
            if(hv.getMaHocVien().equals(maHV)) return hv;
        }
        return null;
    }

    public LopHoc getLopHocTuMaLopHoc(String maLopHoc) {
        for(LopHoc lh: this.getListLopHoc()) {
            if(lh.getMaLopHoc().equals(maLopHoc)) return lh;
        }
        return null;
    }

    public GiaoVien getGiaoVienTuMaGiaoVien(String maGV) {
        for(GiaoVien gv: this.getListGiaoVien()) {
            if(gv.getMaGiaoVien().equals(maGV)) return gv;
        }
        return null;
    }

    public void addHocVien(HocVien hv) {
        this.listHocVien.add(hv);
    }

    public void addLopHoc(LopHoc lh) {
        this.listLopHoc.add(lh);
    }

    public void addGiaoVien(GiaoVien gv) {
        this.listGiaoVien.add(gv);
    }

    public ArrayList<HocVien> getListHocVien() {
        return this.listHocVien;
    }

    public ArrayList<LopHoc> getListLopHoc() {
        return this.listLopHoc;
    }

    public ArrayList<GiaoVien> getListGiaoVien() {
        return this.listGiaoVien;
    }

}
