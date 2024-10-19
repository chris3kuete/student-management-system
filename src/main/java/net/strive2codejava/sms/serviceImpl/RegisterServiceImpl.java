package net.strive2codejava.sms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.strive2codejava.sms.entity.Lecturer;
import net.strive2codejava.sms.repository.RegisterRepository;
import net.strive2codejava.sms.service.RegisterService;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	public RegisterRepository registerRepo;

	@Override
	public Lecturer createLecturer(String firstName, String lastName, String subject, String email, String password) {
		
		Lecturer lect = new Lecturer();
		
		lect.setFirstName(firstName);
		lect.setLastName(lastName);
		lect.setSubject(subject);
		lect.setEmail(email);
		lect.setPassword(password);
		
		return registerRepo.save(lect);
		
	}

	@Override
	public Lecturer checkUser(String email, String password) {
		
		return registerRepo.findByEmailAndPassword(email, password);
	}

	

}
