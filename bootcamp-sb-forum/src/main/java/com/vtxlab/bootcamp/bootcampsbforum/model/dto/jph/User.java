package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// List<User> users
@Getter
// @Setter not required for reading only
// @AllArgsConstructor // Good for testing, but not required for Deserialization
// @NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {

  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  // @Setter
  public static class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Location geo;

    @Getter
    // @Setter
    public static class Location {
      
      private String lat;
      private String lng;
  
    }

  }
  
  @Getter
  // @Setter
  public static class Company {

    private String name;
    private String catchPhrase;
    private String bs;

  }


}
