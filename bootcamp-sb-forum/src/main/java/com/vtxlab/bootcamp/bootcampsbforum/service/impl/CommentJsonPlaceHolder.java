package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

@Service
public class CommentJsonPlaceHolder implements CommentService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.comment}")
  private String commentEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Comment> getComments() {

    // get urlString of outer source via UriComponentsBuilder.newInstance()
    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTP.lowercaseName()) //
        .host(domain) //
        .path(commentEndpoint) //
        .toUriString();

    // Check if able to call 3rd party

    // Use RestTemplate to get actual information from external web server
    // RestTemplate restTemplate = new RestTemplate();

    try {
      // put information into an Array of Comment[]
      Comment[] comments =
          restTemplate.getForObject(urlString, Comment[].class);

      return Arrays.stream(comments).collect(Collectors.toList());
    } catch (RestClientException ex) {

    }

    // use Arrays.stream() and collect(Collector.toList()) to return result as List<Comment> to controller
    return null;


  }



}
