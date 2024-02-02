package com.vtxlab.bootcamp.bootcampsbforum2.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcampsbforum2.controller.CommentOperation;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;
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

    // Get List<comment> related to userId, wrap into Optional

    Optional<UserCommentDTO> userCommentDTO = userService.getUsers() //
        .stream() //
        .filter(e -> e.getId() == userId) //
        .map(e -> {
          List<Comment> comments = commentService.getComments();
          return GovMapper.map(e, comments);
        }) //
        .findFirst();
    
    // Check if Optional isPresent, if true then wrap UserCommentDTO to ApiResp
    if (userCommentDTO.isPresent()) {
      ApiResp<UserCommentDTO> apiResp = ApiResp.<UserCommentDTO>builder() //
                                               .code(Syscode.OK.getCode()) //
                                               .message(Syscode.OK.getMessage()) //
                                               .data(userCommentDTO.get()) //
                                               .build();
      return ResponseEntity.ok(apiResp);
    }

    throw new ResourceNotFound(Syscode.NOTFOUND);

  }



}
