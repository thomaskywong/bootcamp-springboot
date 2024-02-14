package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  // @Id annotation indictates the attibute is primary key
  // @GeneratedValue set to (strategy = GenerationType.IDENTITY) means AUTO_INCREMENT in SQL)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // primary Key

  private String name;

  private String username;

  private String email;

  // private Address address; // One-to-One mapping

  private String phone;

  private String website;

  // private Company company; // One-to-one mapping

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

  @Column(name = "COMPANY_NAME")
  private String cName;

  @Column(name = "COMPANY_CATCH_PHRASE")
  private String cCatchPhrase;

  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String cBusService;

}
