package net.strive2codejava.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.strive2codejava.sms.entity.Lecturer;

public interface RegisterRepository extends JpaRepository<Lecturer, Long>{

	Lecturer findByEmailAndPassword(String email, String password);
	
	

}
