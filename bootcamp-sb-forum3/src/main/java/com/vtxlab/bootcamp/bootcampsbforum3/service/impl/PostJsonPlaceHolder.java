package com.vtxlab.bootcamp.bootcampsbforum3.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum3.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum3.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum3.service.PostService;

@Service
public class PostJsonPlaceHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;


  @Override
  public List<Post> getPosts() {

    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTP.lowercase()) //
        .host(domain) //
        .path(postEndpoint) //
        .toUriString();
    
    RestTemplate restTemplate = new RestTemplate();

    Post[] posts = restTemplate.getForObject(urlString, Post[].class);

    return Arrays.stream(posts).collect(Collectors.toList());

  }

}
