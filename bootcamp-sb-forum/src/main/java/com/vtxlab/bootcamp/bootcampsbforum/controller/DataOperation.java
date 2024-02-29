package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.model.ApiResp2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface DataOperation {

  @Operation(summary = "Get user Data",
      description = "This is endpoint retrieves a user Data from JPH endpoints (/user_info)",
      tags = "Get a user",
      parameters = {
          @Parameter(name = "id", description = "User Id", required = true)})
  @ApiResponses({
      @ApiResponse(responseCode = "200",
          content = {@Content(schema = @Schema(implementation = ApiResp2.class),
              mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          content = {@Content(schema = @Schema())}),
      @ApiResponse(responseCode = "500",
          content = {@Content(schema = @Schema())})})
  @GetMapping(value = "/user_info")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<UserDTO> userInfo(@RequestParam("id") Integer id);

}
