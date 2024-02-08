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
import com.vtxlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@Service
public class PostJsonPlaceHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Post> getPosts() {

    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTP.lowercaseName()) //
        .host(domain) //
        .path(postEndpoint) //
        .toUriString();

    // Use RestTemplate for getting online resources (JSON)
    // RestTemplate restTemplate = new RestTemplate(); // could provide parameters into to constructure. waiting time limited to 3000ms

    try {

      Post[] posts = restTemplate.getForObject(urlString, Post[].class);
      return Arrays.stream(posts).collect(Collectors.toList());

    } catch (RestClientException ex) {
      throw new JPHClientException(Syscode.JPH_NOT_AVAILABLE);
    }
  }

}
