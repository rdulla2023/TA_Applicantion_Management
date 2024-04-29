package org.example.ta.Repository;

import org.example.ta.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseDao extends JpaRepository<Courses,String> {
}
