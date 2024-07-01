package ktech.bai1;

import java.util.ArrayList;

public class Student implements DisplayService {
    private String studentId;
    private String name;
    private int tuoi;
    private ArrayList<CourseOnline> listCourseAssigned;

    Student(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
        this.listCourseAssigned = new ArrayList<>();
    }

    @Override
    public void displayStudent(Student std) {
        DisplayService.super.displayStudent(std);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public ArrayList<CourseOnline> getListCourseAssigned() {
        return listCourseAssigned;
    }

    public void regisToACourse(CourseOnline course) {
        course.addStudentToCouse(this);
        this.listCourseAssigned.add(course);
    }
}
