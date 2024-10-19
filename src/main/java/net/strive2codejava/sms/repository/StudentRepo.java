package net.strive2codejava.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.strive2codejava.sms.entity.Student;


public interface StudentRepo extends JpaRepository<Student, Long>{

}
