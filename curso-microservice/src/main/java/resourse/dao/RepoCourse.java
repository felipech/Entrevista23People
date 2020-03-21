package resourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import resourse.model.Course;

@Repository
public interface RepoCourse extends JpaRepository<Course, Integer> {

}
