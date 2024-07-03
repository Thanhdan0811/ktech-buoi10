package ktech.bai2;

public class LopHocImplement{

    public static void taoLopHocTinh(Database db) {
        LopHoc lh1 = new LopHoc("lop PHP", "php-01");
        LopHoc lh2 = new LopHoc("lop JS", "js-01");
        LopHoc lh3 = new LopHoc("lop NODE", "node-01");
        db.addLopHoc(lh1);
        db.addLopHoc(lh2);
        db.addLopHoc(lh3);
    }

    public static void inRaDanhSachLop(Database db) {
        for(LopHoc lh:  db.getListLopHoc()) {
            System.out.println("Tên lớp học: " + lh.getTenLopHoc() +
                    " | mã lớp: " + lh.getMaLopHoc() +
                    " | Tổng số học viên: " + lh.getListHocVien().size() +
                    " | Danh sách học viên: " + lh.getListHocVien() +
                    " | Danh sách giáo viên: " + lh.getListGiaoVienDangDay()
            );
        }
    }
}
