package com.vtxlab.bootcamp.bootcampsbforum2.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;
import com.vtxlab.bootcamp.bootcampsbforum2.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

  @Value(value = "${api.jdh.domain}")
  private String domain;

  @Value(value = "${api.jdh.endpoints.comment}")
  private String endpoint;

  @Override
  public List<Comment> getComments() {

    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.lowerCase(Scheme.HTTPS)) //
        .host(domain) //
        .path(endpoint) //
        .toUriString();
    
    System.out.println(urlString);

    RestTemplate restTemplate = new RestTemplate();

    Comment[] comments = restTemplate.getForObject(urlString, Comment[].class);

    return Arrays.stream(comments).collect(Collectors.toList());

  }

}
