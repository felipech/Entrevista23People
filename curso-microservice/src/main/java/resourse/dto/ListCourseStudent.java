package resourse.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "listcoursestudent")
public class ListCourseStudent {//this is a view created in the db
	
	@Id
	private String name_course;
	private String code;
	private String name;
	private String lastname;
	private Integer age;
	private String rut;
	
	public ListCourseStudent() {
		
	}
	
	public String getName_course() {
		return name_course;
	}
	public void setName_course(String name_course) {
		this.name_course = name_course;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	
	

}
