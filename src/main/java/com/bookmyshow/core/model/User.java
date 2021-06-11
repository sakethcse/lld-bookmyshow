package com.bookmyshow.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable {

  //attribs
  @Column(unique = true)
  @Getter
  @Setter
  private String email;

  @Getter
  private String saltedHashedPassword;

  //relationsships
  @ManyToMany
  @Getter
  @Setter
  private Set<Role> roles = new HashSet<Role>();

  @OneToOne
  @Getter @Setter
  private Profile profile;

  public User(User user) { // copy constructor
    email = user.getEmail();
    saltedHashedPassword = user.getSaltedHashedPassword();
    roles = user.getRoles();
    profile = user.getProfile();
  }

  public void setSaltedHashedPassword(String value) {
    //this.saltedHashedPassword = new BCryptPasswordEncoder(5).encode(value);
    this.saltedHashedPassword = value;
  }
}
