package com.bookmyshow.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "coupons")
@NoArgsConstructor
@Builder
@Data
public class Coupon extends Auditable {

  //attribs
  private String code;
  private int maxUsage;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date expiresOn = new Date();

  private Coupon(String code) {
    this.code = code;
  }

}
