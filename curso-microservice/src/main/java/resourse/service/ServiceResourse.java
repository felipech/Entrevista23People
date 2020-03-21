package resourse.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import resourse.dao.RepoCourse;
import resourse.dao.RepoCourseStudent;
import resourse.dto.ListCourseStudent;
import resourse.model.Course;
import resourse.model.GroupResultCourse;
import resourse.model.Student;

@Service
public class ServiceResourse {
	
	@PersistenceContext
	private EntityManager etm;
	
	@Autowired
	private RepoCourseStudent repo;
	
	@Autowired
	private RepoCourse repoCourse;
	
	@Value("${query.all.alumns.course}")
	private String test;
	@Value("${query.all.alumns.courseByCode}")
	private String courseByCode;
	
	@Value("${query.checkCourse}") 
	private String checkCourse;
	 
	
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
		int statusRequest = 0; Query query = (Query) getEntityManager().createQuery(checkCourse).setParameter("id", course.getId_course()); 
		statusRequest = (int) query.getSingleResult();
	  
		if(statusRequest == 0) { 
		 //create course 
			return 0; 
		}else { //already exist
			return 1; 
		} 
	}
	 
	
	
	

}
