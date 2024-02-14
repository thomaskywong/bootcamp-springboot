package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

// Service to obtain User list from JavaPlaceHolder
// dedicted service to Gov
// Features:
// Invoke JPH API to retrieve User List
// Store / refresh the whole user list in Database
// return DTO to gov
public interface GovService {
  
    /**
   * 1. Invoke JPH API to retrieve User List
   * 2. Store/ refresh the whole user list in database
   * 3. return to Gov
   * @param id
   * @return User
   */

  // User is DTO from JPH
  User getUser(Long id);

  List<User> getUsers();

}
