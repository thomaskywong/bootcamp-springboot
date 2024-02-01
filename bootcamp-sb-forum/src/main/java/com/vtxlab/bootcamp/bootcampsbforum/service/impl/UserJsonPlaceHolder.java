package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class UserJsonPlaceHolder implements UserService {

  // Read value from resources.yml and assign to local variable
  @Value(value = "${api.jph.domain}")
  private String domain;    

  // Read value from resources.yml and assign to local variable
  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

  // @Value(value = "${api.jph.endpoints.post}")
  // private String userEndpoint2;

  // @Value(value = "${api.jph.endpoints.comment}")
  // private String userEndpoint3;

  // @Override 
  // public List<Post> getPosts() {

  //   // String urlString = url(Scheme.HTTP, domain2, userEndpoint2);

  //   // Generate a URL string for calling 
  //   String urlString = UriComponentsBuilder.newInstance() //
  //                      .scheme(Scheme.HTTPS.name().toLowerCase()) //
  //                      .host(domain) //
  //                      .path(userEndpoint2)
  //                      .toUriString();

  //   RestTemplate restTemplate = new RestTemplate();

  //   Post[] posts = restTemplate.getForObject(urlString, Post[].class);

  //   return Arrays.stream(posts).collect(Collectors.toList());
    
  // }


  @Override
  public List<User> getUsers() {

    // Consume RESTful web service in Spring boot
    // get information from other web servers.
    RestTemplate restTemplate = new RestTemplate();

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
  // public List<Comment> getComments() {

  //   String urlString = url(Scheme.HTTP, domain, userEndpoint3);
    
  //   System.out.println(urlString);

  //   RestTemplate restTemplate = new RestTemplate();

  //   Comment[] comments = restTemplate.getForObject(urlString, Comment[].class);

  //   return Arrays.stream(comments).collect(Collectors.toList());

  // }
}
