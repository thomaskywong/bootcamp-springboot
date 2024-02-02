package com.vtxlab.bootcamp.bootcampsbforum2.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.User;
import com.vtxlab.bootcamp.bootcampsbforum2.service.UserService;

@Service
public class UserJsonPlaceHolder implements UserService {

  // Read value from resources.yml and assign to local variable
  @Value(value = "${api.jph.domain}")
  private String domain;    

  // Read value from resources.yml and assign to local variable
  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

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
        .scheme(scheme.lowerCase()) // .scheme("https") from enum
        .host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character such as : / \ }

  }

}
