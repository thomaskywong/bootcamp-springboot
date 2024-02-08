package com.vtxlab.bootcamp.bootcampsbforum2.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcampsbforum2.controller.CommentOperation;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.User;
import com.vtxlab.bootcamp.bootcampsbforum2.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum2.service.UserService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperation {

  @Autowired
  private CommentService commentService;

  @Autowired
  private UserService userService;


  // @Override
  // public List<Comment> getComments() {
  //   return commentService.getComments();
  // }


  @Override
  public ResponseEntity<ApiResp<UserCommentDTO>> getUserComments(int userId)
      throws ResourceNotFound {

    
    Optional<User> userOp= userService.getUsers().stream() //
                                .filter( e -> e.getId() == userId) //
                                .findFirst();

    if (userOp.isEmpty()) {
      throw new ResourceNotFound(Syscode.NOTFOUND);
    }

    User user = userOp.get();

    List<CommentDTO> commentDTOs = commentService.getComments().stream() //
                                      .filter(e -> e.getPostId() == userId) //
                                      .map( e -> {
                                            return CommentDTO.builder() //
                                                      .postId(e.getPostId()) //
                                                      .name(e.getName()) //
                                                      .email(e.getEmail()) //
                                                      .body(e.getBody()) //
                                                      .build(); //
                                            }) //
                                      .collect(Collectors.toList());
    
    UserCommentDTO userCommentDTO = UserCommentDTO.builder() //
                                                  .id(user.getId()) //
                                                  .username(user.getUsername()) //
                                                  .email(user.getEmail()) //
                                                  .phone(user.getPhone()) //
                                                  .commentDTOs(commentDTOs) //
                                                  .build(); //
    
    ApiResp<UserCommentDTO> apiResp = ApiResp.<UserCommentDTO>builder() //
                                             .code(Syscode.OK.getCode()) //
                                             .message(Syscode.OK.getMessage()) //
                                             .data(userCommentDTO) //
                                             .build();
   
    return ResponseEntity.ok(apiResp);


  }



}
