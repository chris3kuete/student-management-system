package net.strive2codejava.sms.service;

import net.strive2codejava.sms.entity.Lecturer;

public interface RegisterService {

	Lecturer createLecturer(String firstName, String lastName, String subject, String email, String password);

	Lecturer checkUser(String email, String password);

}
