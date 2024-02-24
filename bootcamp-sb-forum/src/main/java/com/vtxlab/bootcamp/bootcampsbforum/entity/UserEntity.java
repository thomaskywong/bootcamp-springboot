package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity annotation indictates the class is an entity to database
// @Table(name = "xxx") annotation indicates the table name in database
// Entity class shall implements interface Serializable (java.io) (from Java to Database)
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @Builder // Do not use Builder for DB deserialization
// @ToString // Do not use ToString
public class UserEntity implements Serializable {

  // Serializable. Update UID everytime modify Entity
  // Serializable for Database
  // Restful API has Serializable implicitly
  // indication of entity version identification
  private static final long serialVersionUID = 2L;

  // @Id annotation indictates the attibute is primary key
  // @GeneratedValue set to (strategy = GenerationType.IDENTITY) means AUTO_INCREMENT in SQL)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // primary Key

  private String name;

  private String username;

  private String email;

  private String phone;

  private String website;

  // private Address address; // One-to-One mapping
  private String street;

  private String suite;

  private String city;

  private String zipcode;

  // private Location geo; // One-to-One Mapping

  // alias of column shown on database table. Jakarta Persistence
  @Column(name = "ADDRESS_LAT")
  private String addrLat;

  @Column(name = "ADDRESS_LONG")
  private String addrLong;

  // private Company company; // One-to-one mapping
  @Column(name = "COMPANY_NAME")
  private String cName;

  @Column(name = "COMPANY_CATCH_PHRASE")
  private String cCatchPhrase;

  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String cBusService;

  // one-to-many
  // cascade: when parent is add/delete/update, child will be added/delete/update
  // orphanRemoval = true: remove child elements that is not related
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // serialization
  @JsonManagedReference // prevent infinite loop
  private List<PostEntity> posts = new ArrayList<>(); // references points to the whole post list related to user

}
