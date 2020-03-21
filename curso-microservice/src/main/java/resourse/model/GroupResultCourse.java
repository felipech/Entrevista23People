package resourse.model;

public class GroupResultCourse {
	
	
	private Course course;
	private Student student;
	private Student_has_course student_has_course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student_has_course getStudent_has_course() {
		return student_has_course;
	}
	public void setStudent_has_course(Student_has_course student_has_course) {
		this.student_has_course = student_has_course;
	}
	
	

}
