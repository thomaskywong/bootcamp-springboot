package com.vtxlab.bootcamp.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository // Bean
public interface UserRepository extends JpaRepository<User, Long> {

  // Hibernate - Framework (implementation class) 
  // Hibernate: New bean -> spring Context 
  // objective: implements JPA interface
  
}
