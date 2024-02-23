package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

// Annotation for indicating self defined Repository
// UserRepository is an interface that implements JpaRepository interface (for all SQL database languages)
@Repository  // Repository annotation
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // Hibernate (implementation class) -> Bean -> Spring Context
  // Objective: Implement JPA interface (Java Persistence Application Interface)

  // Contains all methyod in JpaRepository
  // ID of JpaRepository usually Long or Integer

  // GET
  // 1. Query "Method" - name of method shall be precise (ie. table name, findBy, ...)
  // Method Generation
  // select * from users where username = ?
  UserEntity findByUsername(String username);

  // Sort sort is injected by springframework
  // import org.springframework.data.domain.Sort;
  List<UserEntity> findAllByEmailAndPhone(String email, String phone, Sort sort);

  List<UserEntity> findAllByEmailAndPhoneOrderByEmailDesc(String email, String phone);

  // 2. JPQL (Shall use JPQL only!)
  // explicit query provided
  @Query("SELECT e FROM UserEntity e WHERE CAST(e.addrLat AS double) > :lat")
  List<UserEntity> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);

  
  // PATCH
  // JPQL (patch)
  // @Modifying + Query
  @Modifying
  @Query("UPDATE UserEntity u SET u.email = :newEmail WHERE u.id = :userId")
  void updateUserEmail(@Param("userId") long id, @Param("newEmail") String email);


  // 3. Native Query (SQL product dependent)
  @Query(value = "SELECT count(1) FROM USERS u WHERE lower(u.name) LIKE lower(concat(:prefix,'%'))", nativeQuery = true)
  Long countUserByNameStartsWith(@Param("prefix") String prefix);



}

// CRUD methods enforced by JpaRespository interface:
//
// public List<User> findAll();
// public User findById(Long id);
// public List<User> findAllById(Iterable<Long> ids) {
// public <S extends User> List<S> saveAll(Iterable<S> entities) {
// public long count() {
// public void delete(User entity) {
// public void deleteAll() {
// public void deleteAll(Iterable<? extends User> entities) {
// public void deleteAllById(Iterable<? extends Long> ids) {
// public void deleteById(Long id) {
// public boolean existsById(Long id) {
// public Optional<User> findById(Long id) {
// public <S extends User> S save(S entity) {
// public List<User> findAll(Sort sort) {
// public Page<User> findAll(Pageable pageable) {
// public <S extends User> long count(Example<S> example) {
// public <S extends User> boolean exists(Example<S> example) {
// public <S extends User> Page<S> findAll(Example<S> example,
// Pageable pageable) {
// public <S extends User, R> R findBy(Example<S> example,
// public <S extends User> Optional<S> findOne(Example<S> example) {
// public void flush() {
// public <S extends User> S saveAndFlush(S entity) {
// public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
// public void deleteAllInBatch(Iterable<User> entities) {
// public void deleteAllByIdInBatch(Iterable<Long> ids) {
// public void deleteAllInBatch() {
// public User getOne(Long id) {
// public User getById(Long id) {
// public User getReferenceById(Long id) {
// public <S extends User> List<S> findAll(Example<S> example) {
// public <S extends User> List<S> findAll(Example<S> example, Sort sort) {


// }
