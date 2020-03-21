package resourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import resourse.model.Student;


@Repository
public interface RepoCourseStudent extends JpaRepository<Student, Integer> {

}
