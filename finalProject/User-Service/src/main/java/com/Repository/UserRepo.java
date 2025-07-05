package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
 public Optional<User> findByEmail(String email);

}
