package com.bookmyshow.core.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
    generator = ObjectIdGenerators.StringIdGenerator.class,
    property = "id"
)
public abstract class Auditable implements Serializable {

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
  private Date createdAt = new Date();

  @Column(nullable = false)
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Getter
  @Setter
  private Date updatedAt = new Date();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() == o.getClass()) return false;
    com.bookmyshow.core.model.Auditable auditable = (com.bookmyshow.core.model.Auditable) o;
    return Objects.equals(id, auditable.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
