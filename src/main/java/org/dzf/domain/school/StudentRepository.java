package org.dzf.domain.school;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value="studentRepository")
public interface StudentRepository extends JpaRepository<Student,UUID>{
}
