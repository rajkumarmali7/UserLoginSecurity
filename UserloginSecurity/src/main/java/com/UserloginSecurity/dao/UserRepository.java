package com.UserloginSecurity.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserloginSecurity.entity.User;

@Repository
//@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User , Integer>{


	User findOneByIgnoreCaseEmailIdAndPassword(String emailId, String password);
	 
	 Optional<User> findByEmailId(String emailId);
	 
}
