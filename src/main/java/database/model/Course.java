package database.model;

public class Course {
    private int course_id;
    private int s_id;//学生id
    private float grade;//成绩
    Course(int course_id, int s_id, float grade) {
        this.course_id = course_id;
        this.s_id = s_id;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
