package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.exception.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserJsonPlaceHolder implements UserService {

  // Read value from resources.yml and assign to local variable
  @Value(value = "${api.jph.domain}")
  private String domain;

  // Read value from resources.yml and assign to local variable
  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  // for putting object into Database
  // Similar to Autowired. EntityManager from context container
  @PersistenceContext  // Persistence EntityManager
  private EntityManager entityManager;

  @Override
  public User getUser(Long id) {
    String userUrl = url(Scheme.HTTP, domain, userEndpoint);
    User[] users = restTemplate.getForObject(userUrl, User[].class);
    
    Optional<User> userOp =  Arrays.stream(users).filter(e -> e.getId() == id).findFirst();
  
    if (userOp.isEmpty())
      throw new ResourceNotFound(Syscode.NOTFOUND);
    
    return userOp.get();
    

  }


  @Override
  public List<User> getUsers() {

    // Consume RESTful web service in Spring boot
    // get information from other web servers.
    // Use @Bean in @Configuration. No new RestTemplated is needed locally
    // RestTemplate restTemplate = new RestTemplate();

    // System.out.println("domain="+ domain);
    // System.out.println("userEndpoint="+ userEndpoint);

    String userUrl = url(Scheme.HTTP, domain, userEndpoint);

    // System.out.println("userUrl="+ userUrl);

    Objects.requireNonNull(userUrl);

    // get JSON from website then convert JSON to User[] in Java
    User[] users = restTemplate.getForObject(userUrl, User[].class);

    Objects.requireNonNull(users);

    // System.out.println("after restTemplate");
    // System.out.println(Arrays.toString(users));
    // System.out.println(users[0].getAddress().getStreet());
    // System.out.println(users[0].getAddress().getGeo().getLat());

    return Arrays.stream(users).collect(Collectors.toList());

  }

  // Public tools that converts scheme, domain name and endpoint path into a single string then return
  private static String url(Scheme scheme, String domain, String endpoint) {

    Objects.requireNonNull(domain);
    Objects.requireNonNull(endpoint);

    //
    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercaseName()) // .scheme("https") from enum
        .host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character such as : / \ }

  }

  // @Override
  // public UserEntity findById(Long id) {
    
  //   Optional<UserEntity> userOp = userRepository.findById(id);

  //   if (userOp.isEmpty())
  //     throw new ResourceNotFound(Syscode.NOTFOUND);
    
  //   return userOp.get();
  // }

  @Override
  public List<UserEntity> findAll() {
    return userRepository.findAll();
  }

  // @Override
  // public Long countUserByName(String prefix) {
  //   return userRepository.countUserByNameStartsWith(prefix);
  // }

  // @Override
  // public List<UserEntity> findAllByAddr(
  //     Double Latitude) {
  //   return userRepository.findAllByAddrLatGreaterThan(Latitude);
  // }

  // @Override
  // public List<UserEntity> findAllByEmailAndPhoneDesc(
  //     String email, String phone) {
  //   return userRepository.findAllByEmailAndPhoneOrderByEmailDesc(email, phone);
  // }

  // @Override
  // public List<UserEntity> findAllByEmailOrPhoneDesc(
  //     String email, String phone) {
  //   Sort sort = Sort.by("email").and(Sort.by(Sort.Direction.DESC, "phone"));
  //   return userRepository.findAllByEmailOrPhone(email, phone, sort);
  // }

  // Update (PATCH) PostgreSQL using @Transactional
  // Proceeds all statement first, then commit change to database
  // @Override
  // @Transactional // All success or Nothing. Since database may be accessed by other enquiry
  // public void updateUserEmail(Long id, String email) {

  //   userRepository.updateUserEmail(id, email);
  //   // return userRepository.findById(id).get();
  // }

  // @Override
  // @Transactional // All success or Nothing. Since database may be accessed by other enquiry
  public UserEntity updateUserById(Long id,UserEntity newUser) {

    // entityManager.find() -> SELECT
    UserEntity oldUser = entityManager.find(UserEntity.class, id);

    // oldUser.setId(newUser.getId());
    oldUser.setName(newUser.getName());
    oldUser.setUsername(newUser.getUsername());
    oldUser.setEmail(newUser.getEmail());
    oldUser.setPhone(newUser.getPhone());
    oldUser.setWebsite(newUser.getWebsite());
    oldUser.setStreet(newUser.getStreet());
    oldUser.setSuite(newUser.getSuite());
    oldUser.setCity(newUser.getCity());
    oldUser.setZipcode(newUser.getZipcode());
    oldUser.setAddrLat(newUser.getAddrLat());
    oldUser.setAddrLong(newUser.getAddrLong());
    oldUser.setCName(newUser.getCName());
    oldUser.setCCatchPhrase(newUser.getCCatchPhrase());
    oldUser.setCBusService(newUser.getCBusService());

    // entityManager.merge() -> UPDATE
    entityManager.merge(oldUser);

    return oldUser;
  }



}
