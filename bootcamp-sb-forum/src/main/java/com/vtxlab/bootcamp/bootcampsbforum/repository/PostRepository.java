package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

  // // 1) Query Method
  // List<PostEntity> findAllByUserId(Long id);

  // // 2) Query by JPQL
  // // SELECT
  // @Query("SELECT e FROM PostEntity e WHERE e.userId = :id") 
  // List<PostEntity> getDBPostByIdJPQL(@Param("id") Long id);

  // // UPDATE
  // @Modifying
  // @Query("UPDATE PostEntity e SET e.body = :body WHERE e.id = :id")
  // void setPostBodyByPostId(@Param("body") String body, @Param("id") Long id);

  // @Modifying
  // @Query("UPDATE PostEntity e SET e.title = :title WHERE e.id = :id")
  // void setPostTitleByPostId(@Param("title") String title, @Param("id") Long id);

  // @Modifying
  // @Query("UPDATE PostEntity e SET e.userId = :userId WHERE e.id = :id")
  // void setPostUserIdByPostId(@Param("userId") Long userId, @Param("id") Long id);

  // // 3) Native SQL
  // @Query(value = "SELECT * FROM posts p WHERE p.user_id = :id", nativeQuery = true)
  // List<PostEntity> getPostByIdSQL(@Param("id") Long id);
  
}
