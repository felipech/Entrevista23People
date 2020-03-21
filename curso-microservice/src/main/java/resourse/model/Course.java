package resourse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course implements Serializable{
	
	@Id
	@GeneratedValue
	private int id_course;
	
	private String name_course;
	private String code;
	//private List<Student> stundents;
	
	
	public String getCode() {
		return code;
	}
	public int getId_course() {
		return id_course;
	}
	public void setId_course(int id_course) {
		this.id_course = id_course;
	}
	public String getName_course() {
		return name_course;
	}
	public void setName_course(String name_course) {
		this.name_course = name_course;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
