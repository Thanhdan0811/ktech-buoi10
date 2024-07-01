package ktech.bai1;

public class CourseOnline extends Course implements DisplayService {
    private String platform;
    private int duration;

    CourseOnline(String courseName, String mentorName, int credit, String platform, int duration) {
        super(courseName, mentorName, credit);
        this.platform = platform;
        this.duration = duration;
    }

    @Override
    public void setCourseId(String courseId) {
        super.setCourseId(courseId);
    }

    @Override
    public String getCourseId() {
        return super.getCourseId();
    }

    @Override
    public void displayDetailCourse(CourseOnline crOn) {
        DisplayService.super.displayDetailCourse(crOn);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getDuration() {



        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
