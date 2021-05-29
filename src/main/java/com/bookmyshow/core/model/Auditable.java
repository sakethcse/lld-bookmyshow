package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.date.annotation.CreateDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class Auditable {

  @Id
  @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "sequence", allocationSize = 10)
  @Getter
  @Setter
  private Long id;

  @Column(nullable = false, updatable = false)
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Getter
  @Setter
  private Date createdAt;

  @Column(nullable = false)
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Getter
  @Setter
  private Date updatedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() == o.getClass())return false;
    Auditable auditable = (Auditable) o;
    return Objects.equals(id, auditable.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
