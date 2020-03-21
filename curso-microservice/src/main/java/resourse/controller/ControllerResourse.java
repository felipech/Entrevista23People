package resourse.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import resourse.dto.ListCourseStudent;
import resourse.model.Course;
import resourse.model.Student;
import resourse.service.ServiceResourse;

@RestController
@RequestMapping("/app")
public class ControllerResourse {
	
	@Autowired
	private ServiceResourse serviceResourse;
	
	@RequestMapping("/")
    public String index() {
        return "probando request mapping eclipse";
    }
	

	
	@RequestMapping(value = "/GET/Student/{id}", method = RequestMethod.GET)
	public Optional<Student> getStudentById(@PathVariable("id") Integer id) {
		return serviceResourse.getStudent(id);
	}
	
	@RequestMapping(value = "/GET/Course/{id}", method = RequestMethod.GET)
	public Optional<Course> getCourseById(@PathVariable("id") Integer id) {
		return serviceResourse.getCourse(id);
	}
	
	@RequestMapping(value = "/GET/Course/all", method = RequestMethod.GET)
	public List<Course> getAllCoursesMapping(){
		return serviceResourse.getAllCourses();
	}
	
	@RequestMapping(value = "/GET/AllStudentsFromCourse", method = RequestMethod.GET) 
	public List<ListCourseStudent> getAllStudentCourses(){ 
		return serviceResourse.getCourseStudentList(); 
	}
	@RequestMapping(value = "/GET/AllStudentsFromCourseByCode/{code}", method = RequestMethod.GET) 
	public List<ListCourseStudent> getAllStudentCoursesByCode(@PathVariable("code") String code){ 
		return serviceResourse.getCourseStudentByCode(code); 
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/POST/Course", method = RequestMethod.POST) 
	public ResponseEntity<?> createNewCourse(@RequestBody Course course){
  
		int response = serviceResourse.crateCourse(course);
  
		if(response == 0) { 
			return new ResponseEntity<>(201, HttpStatus.CREATED);
		}else { 
			return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
		}
  
  
	}
	
	@ResponseBody
	@RequestMapping(value = "/PUT/Course/{code}/", method = RequestMethod.PUT) 
	public ResponseEntity<?> updateCourse(@PathVariable("code") String code ,@RequestBody Course course){
  
		int response = serviceResourse.updateCourse(code,course);
  
		if(response == 0) { 
			return new ResponseEntity<>(200, HttpStatus.OK);
		}else { 
			return new ResponseEntity<>(404, HttpStatus.NOT_FOUND);
		}
  
  
	}
	
	@ResponseBody
	@RequestMapping(value = "/DELETE/Course/{code}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> DeleteCourse(@PathVariable("code") String code ){
  
		int response = serviceResourse.deleteCourse(code);
  
		if(response == 0) { 
			return new ResponseEntity<>(200, HttpStatus.OK);
		}else { 
			return new ResponseEntity<>(404, HttpStatus.NOT_FOUND);
		}
  
  
	}
	 
	
	
	

}
