package resourse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import resourse.model.Course;

@Repository
public class ReporCustomCourseImpl implements ReporCustomCourse {

	@PersistenceContext
	private EntityManager etm;
	
	@Value("${query.checkCourse}") 
	private String checkCourse;
	
	@Value("${insert.newCourse}") 
	private String inserNewCourse;
	
	@Value("${update.course}")
	private String updateCourse;
	
	@Value("${query.id.course}")
	private String getIdForDelete;
	
	@Value("${delete.cascade.course}")
	private String deleteIntermediateTableData;
	
	@Value("${delete.course}")
	private String deleteCourse;
	
	public EntityManager getEntityManager() {
        return etm;
    }
	
	@Override
	public int chekCourse(Course course) {
		Long statusRequest = null;
		System.out.println("status return " + statusRequest);
		Query query = (Query) getEntityManager().createQuery(checkCourse).setParameter(1, course.getCode()); 
		statusRequest =  (Long) query.getSingleResult();
		
		System.out.println("status return " + statusRequest);
		return statusRequest.intValue();
	}
	
	@Transactional
	@Override
	public void insertNewCourseDB(Course course) {
		etm.createNativeQuery(inserNewCourse)
	      .setParameter(1, course.getName_course())
	      .setParameter(2, course.getCode())
	      .executeUpdate();
	}
	
	@Transactional
	@Override
	public void updateCourseDB(Course course) {
		etm.createNativeQuery(updateCourse)
	      .setParameter(1, course.getName_course())
	      .setParameter(2, course.getCode())
	      .setParameter(3, course.getCode())
	      .executeUpdate();
	}

	@Override
	@Transactional
	public int deleteCourseDB(int id_course) {
		
		try {
			etm.createNativeQuery(deleteIntermediateTableData)
		      .setParameter(1, id_course)
		      .executeUpdate();
			etm.createNativeQuery(deleteCourse)
		      .setParameter(1, id_course)
		      .executeUpdate();
			return 0;
		}catch(Exception e) {
			return 1;
		}
		
	}

	@Override
	public int chekCourseAndReturnId(String code) {
		Integer idForDelete = null;
		System.out.println("status idForDelete " + idForDelete);
		Query query = (Query) getEntityManager().createQuery(getIdForDelete).setParameter(1, code);
		System.out.println("status idForDelete " + idForDelete);
		idForDelete = (Integer) query.getSingleResult();
		System.out.println("status idForDelete " + idForDelete);
		return idForDelete;
	}
}
