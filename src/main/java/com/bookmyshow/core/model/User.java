package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class User extends Auditable {

  //attribs
  @Column(unique = true)
  @Getter @Setter
  private String email;

  private String saltedHashedPassword;

  //relationsships
  @ManyToMany
  private List<Role> roles = new ArrayList<>();

  @OneToOne
  private Profile profile;
}
