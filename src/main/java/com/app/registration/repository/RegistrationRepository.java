package com.app.registration.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.registration.model.User;


public interface RegistrationRepository extends JpaRepository<User,Integer>{
	
	@Autowired
	@Query(value = "select * From USER u where u.email_ID = ?1 ORDER BY u.id LIMIT 1", nativeQuery=true)	
	public User findByEmailId(String emailId);
	@Autowired
	@Query(value = "select * From USER u where u.email_ID = ?1 and u.password = ?2 ORDER BY u.id LIMIT 1", nativeQuery=true)	
	public User findByEmailIdAndPassword(String emailId,String password);

}
