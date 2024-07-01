package ktech.bai1;

public interface DisplayService {

    default void displayDetailCourse(CourseOnline crOn){
        System.out.println("Thông tin khóa học:");
        System.out.println("Tên khóa học: " + crOn.courseName);
        System.out.println("Số học viên tham gia : " + crOn.getListStudentAssiged().size());
        System.out.println("Thời lượng khóa học: " + crOn.getDuration() + " phút");

    };
    default void displayStudent(Student std){
        System.out.println("Thông tin học viên");
        System.out.println("Tên học viên: " + std.getName());
        System.out.println("Tuổi học viên: " + std.getTuoi());
        System.out.println("Số khóa học đang tham gia: " + std.getListCourseAssigned().size());
    };
}
