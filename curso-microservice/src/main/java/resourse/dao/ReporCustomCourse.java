package resourse.dao;

import resourse.model.Course;

public interface ReporCustomCourse {
	
	public int chekCourse(Course course);
	public void insertNewCourseDB(Course course);
	public void updateCourseDB(Course course);
	public int deleteCourseDB(int id_course);
	public int chekCourseAndReturnId(String code);

}
