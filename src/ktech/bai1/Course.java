package ktech.bai1;

import java.util.ArrayList;

public class Course {
    protected String courseId;
    protected String courseName;
    protected String mentorName;
    protected int credit;
    protected ArrayList<Student> listStudentAssiged;

    Course(String courseName, String mentorName, int credit) {
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
        this.listStudentAssiged = new ArrayList<>();
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void addStudentToCouse(Student std) {
        if(std == null) return;
        this.listStudentAssiged.add(std);
    }

    public ArrayList<Student> getListStudentAssiged() {
        return listStudentAssiged;
    }
}
