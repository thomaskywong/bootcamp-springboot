package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Entity
@Table(name = "Users")
@Getter
@AllArgsConstructor
public class User implements Serializable {

  // Primary Key declare
  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
  private Long id; // primary key
  private String name;
  private String username;
  private String email;
  // private Address address; // One-to-One mapping
  private String phone;
  private String website;
  // private Company company; // One-to-one mapping
  @Column(name = "ADDESS_STREET")
  private String addrStreet;
  private String suite;
  private String city;
  private String zipcode;
  // private Location geo; // One-to-One Mapping
  @Column(name = "ADDRESS_LAT")
  private String addrLat;
  @Column(name = "ADDRESS_LNG")
  private String addrLong;
  @Column(name = "COMPANY_NAME")
  private String cName;
  @Column(name = "COMPANY_CATCH_PHRASE")
  private String cCatchPhrase;
  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String cBusService;

}


