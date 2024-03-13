package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.PostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

@Component
public class RequestDTOMapper {

  @Autowired
  private PostMapper postMapper;

  public PostRequestDTO mapToPostRequestDTO(Post post) {

    return PostRequestDTO.builder() //
        .title(post.getTitle()) //
        .body(post.getBody()) //
        .build();
  }

  public PostEntity mapToPostEntity(PostRequestDTO postDto) {
    return new PostEntity(null, //
        postDto.getTitle(), //
        postDto.getBody(), //
        null);
  }

  public PostRequestDTO mapToPostRequestDTO(PostEntity postEntity) {
    return PostRequestDTO.builder() //
        .title(postEntity.getTitle()) //
        .body(postEntity.getBody()) //
        .build();
  }

  public UserRequestDTO mapToUserRequestDTO(User user, List<Post> posts) {

    List<PostRequestDTO> dtos = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> this.mapToPostRequestDTO(e)) //
        .collect(Collectors.toList());

    return UserRequestDTO.builder() //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .website(user.getWebsite()) //
        .street(user.getAddress().getStreet()) //
        .suite(user.getAddress().getSuite()) //
        .city(user.getAddress().getCity()) //
        .zipcode(user.getAddress().getZipcode()) //
        .addrLat(user.getAddress().getGeo().getLatitude()) //
        .addrLong(user.getAddress().getGeo().getLongtitude()) //
        .companyName(user.getCompany().getName()) //
        .companyCatchPhrase(user.getCompany().getCatchPhrase()) //
        .companyBusService(user.getCompany().getBusinessService()) //
        .posts(dtos) //
        .build();
  }

  public UserRequestDTO mapToUserRequestDTO(UserEntity entity) {

    List<PostRequestDTO> postRequestDTOs = entity.getPosts().stream() //
        .map(e -> this.mapToPostRequestDTO(e)) //
        .collect(Collectors.toList());

    return UserRequestDTO.builder() //
        .name(entity.getName()) //
        .username(entity.getUsername()) //
        .email(entity.getEmail()) //
        .phone(entity.getPhone()) //
        .website(entity.getWebsite()) //
        .street(entity.getStreet()) //
        .suite(entity.getSuite()) //
        .city(entity.getCity()) //
        .zipcode(entity.getZipcode()) //
        .addrLat(entity.getAddrLat()) //
        .addrLong(entity.getAddrLong()) //
        .companyName(entity.getCName()) //
        .companyCatchPhrase(entity.getCCatchPhrase()) //
        .companyBusService(entity.getCBusService()) //
        .posts(postRequestDTOs) //
        .build();
  }

  // UserPostRequestDTO -> UserEntity
  public UserEntity mapToUserEntity(UserPostRequestDTO dto) {
    // Step 1: create UserEntity object with User's value
    UserEntity userEntity = new UserEntity(null, //
        dto.getName(), //
        dto.getUsername(), //
        dto.getEmail(), //
        dto.getPhone(), //
        dto.getWebsite(), //
        dto.getStreet(), //
        dto.getSuite(), //
        dto.getCity(), //
        dto.getZipcode(), //
        dto.getAddrLat(), //
        dto.getAddrLong(), //
        dto.getCompanyName(), //
        dto.getCompanyCatchPhrase(), //
        dto.getCompanyBusService(), //
        null);
    // Step 2: extract List<PostEntity> from List<PostRequestDTO> of UserPostRequestDTO
    // pass userEntity reference into each PostEntity.
    List<PostEntity> postEntities = dto.getPosts().stream() //
        .map(e -> { //
          PostEntity postEntity = this.mapToPostEntity(e); //
          postEntity.setUser(userEntity); //
          return postEntity; //
        }) //
        .collect(Collectors.toList());

    // Step 3: assign List<PostEntity> object to UserEntity's List<PostEntity> reference
    userEntity.setPosts(postEntities);

    return userEntity;

  }

  // UserPostRequestDTO -> UserEntity
  public UserEntity mapToUserEntity(User user, List<Post> posts) {
    // Step 1: create UserEntity object with User's value
    UserEntity userEntity = new UserEntity(null, //
        user.getName(), //
        user.getUsername(), //
        user.getEmail(), //
        user.getPhone(), //
        user.getWebsite(), //
        user.getAddress().getStreet(), //
        user.getAddress().getSuite(), //
        user.getAddress().getCity(), //
        user.getAddress().getZipcode(), //
        user.getAddress().getGeo().getLatitude(), //
        user.getAddress().getGeo().getLongtitude(), //
        user.getCompany().getName(), //
        user.getCompany().getCatchPhrase(), //
        user.getCompany().getBusinessService(), //
        null);
    // Step 2: extract List<PostEntity> from List<PostRequestDTO> of UserPostRequestDTO
    // pass userEntity reference into each PostEntity.
    List<PostEntity> postEntities = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> { //
          PostEntity postEntity = postMapper.mapToEntity(e); //
          postEntity.setUser(userEntity); //
          return postEntity; //
        }) //
        .collect(Collectors.toList());

    // Step 3: assign List<PostEntity> object to UserEntity's List<PostEntity> reference
    userEntity.setPosts(postEntities);

    return userEntity;

  }



}
