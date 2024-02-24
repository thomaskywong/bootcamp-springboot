package com.vtxlab.bootcamp.bootcampsbforum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @ToString serialization problem
// @Builder avoid builder
@Entity
@Table(name = "posts")
public class PostEntity {

  @Id // Primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
  private Long id;

  // Foreign Key
  // Spring boot cannot process foreign key
  // No longer needed for 
  // @Column(name = "USER_ID")
  // private Long userId;

  @Column(name = "title")
  private String title;
  
  @Column(name = "body")
  private String body;

 
  // Heap
  // step 1: UserEntity userEntity = new UserEntity(xxx), save object reference by private userEntity user
  // step 2: postEntity.setUser(userEntity)
  // step 3: userEntity.setPosts(postEntityes)

  // implementation of foreign key
  @ManyToOne
  @JoinColumn(name = "user_id") // FOREIGN KEY (user_id) REFERENCES user (id)  
  @JsonBackReference // prevent infinite loop
  private UserEntity user; // object reference


}
