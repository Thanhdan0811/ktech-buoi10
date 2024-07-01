package ktech.bai1;

import java.util.ArrayList;

public class CourseApp {

    static private ArrayList<CourseOnline> listCourse = new ArrayList<>();
    static private ArrayList<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {

        // Tạo dữ liệu tĩnh
        addStudent();
        addCourse();

        // lấy ra student 1 và course 1
        Student std1 = listStudent.get(0);
        CourseOnline course1 = listCourse.get(0);

        // đăng ký khóa 1 cho student 1
        std1.regisToACourse(course1);

        // hiển thị thông tin
        std1.displayStudent(std1);
        System.out.println("======================");
        course1.displayDetailCourse(course1);

    }

    private static void addStudent() {
        Student std1 = new Student("std 1", 24);
        std1.setStudentId("std-1");
        Student std2 = new Student("std 2", 19);
        std2.setStudentId("std-2");
        Student std3 = new Student("std 3", 18);
        std3.setStudentId("std-3");
        Student std4 = new Student("std 4", 20);
        std4.setStudentId("std-4");

        listStudent.add(std1);
        listStudent.add(std2);
        listStudent.add(std3);
        listStudent.add(std4);

    }

    private static void addCourse() {
        CourseOnline course1 = new CourseOnline("PHP", "mentor-1", 3, "Youtube", 200);
        course1.setCourseId("coure-1");
        CourseOnline course2 = new CourseOnline("JS", "mentor-2", 2, "Facebook", 120);
        course2.setCourseId("coure-2");
        CourseOnline course3 = new CourseOnline("NODEJS", "mentor-3", 4, "Zoom", 300);
        course3.setCourseId("coure-3");
        CourseOnline course4 = new CourseOnline("HTML-CSS", "mentor-4", 6, "Youtube", 150);
        course4.setCourseId("coure-4");

        listCourse.add(course1);
        listCourse.add(course2);
        listCourse.add(course3);
        listCourse.add(course4);
    }

}
