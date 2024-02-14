package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import com.fasterxml.jackson.annotation.JsonProperty;
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

  private int id; // primary key
  private String name;
  private String username;
  private String email;
  private Address address; // One-to-One mapping
  private String phone;
  private String website;
  private Company company;  // One-to-one mapping

  @Getter
  // @Setter
  public static class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Location geo; // One-to-One Mapping

    @Getter
    // @Setter
    public static class Location {
      
      // change attribute name from web to local name
      @JsonProperty(value = "lat")
      private String latitude;
      
      @JsonProperty(value = "lng")
      private String longtitude;
  
    }

  }
  
  @Getter
  // @Setter
  public static class Company {

    private String name;
    private String catchPhrase;

    @JsonProperty(value = "bs")
    private String businessService;

  }


}
