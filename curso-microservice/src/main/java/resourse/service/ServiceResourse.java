package resourse.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import resourse.dao.RepoCourse;
import resourse.dao.RepoCourseStudent;
import resourse.dao.ReporCustomCourseImpl;
import resourse.dto.ListCourseStudent;
import resourse.model.Course;
import resourse.model.Student;

@Service
public class ServiceResourse {
	
	@PersistenceContext
	private EntityManager etm;
	
	@Autowired
	private RepoCourseStudent repo;
	
	@Autowired
	private RepoCourse repoCourse;
	@Autowired
	private ReporCustomCourseImpl reporCustomCourseImpl;
	
	@Value("${query.all.alumns.course}")
	private String test;
	@Value("${query.all.alumns.courseByCode}")
	private String courseByCode;
	

	 
	
	public EntityManager getEntityManager() {
        return etm;
    }
	
	public ListCourseStudent listCourseStudent; 
	public List<ListCourseStudent>courseStudentList; 
	 //public TypedQuery<ListCourseStudent> CourseStudent;
	 
	 
	public Optional<Student> getStudent(Integer id) {
		return repo.findById(id);
	}
	
	public Optional<Course> getCourse(Integer id) {
		return repoCourse.findById(id);
	}
	
	public List<Course> getAllCourses(){
		return repoCourse.findAll();
	}
	
	
	public List<ListCourseStudent> getCourseStudentList(){ 
		return getEntityManager().createQuery(test).getResultList(); 
	}
	public List<ListCourseStudent> getCourseStudentByCode(String Code){ 
		return  getEntityManager().createQuery(courseByCode).setParameter(1, Code).getResultList(); 
	}
	  
	
	public int crateCourse(Course course) {
		int statusCheck = 0;
		
		statusCheck = reporCustomCourseImpl.chekCourse(course);
	  
		if(statusCheck == 0) {
			//return of statusCheck was 0, so we can create a new course
			reporCustomCourseImpl.insertNewCourseDB(course);
			return 0; 
		}else { 
			//the code already exist
			return 1; 
		} 
	}
	
	public int updateCourse(String code,Course course) {
		int statusCheck = 0;
		statusCheck = reporCustomCourseImpl.chekCourse(course);
		if(statusCheck == 1) {
			//return of statusCheck was 1, so we can update a course because exist in the db
			reporCustomCourseImpl.updateCourseDB(course);
			return 0; 
		}else { 
			//the code already exist
			return 1; 
		} 
		
	}
	public int deleteCourse(String code) {
		int id_for_delete = 0;
		int succesDelete = 0;
		try {
			
			id_for_delete = reporCustomCourseImpl.chekCourseAndReturnId(code);
			if(id_for_delete != 0 ) {
				//return of chekCourseAndReturnId was different to 0, so we can past the id to the function for delete from the db
				succesDelete = reporCustomCourseImpl.deleteCourseDB(id_for_delete);
				return succesDelete; 
			}else { 
				//the code already exist
				return 1; 
			} 
		
		}catch(Exception e) {
			return 1; 
		}

	}
	
	
	

}
