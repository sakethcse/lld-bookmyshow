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

  public static final class CouponBuilder{
    private String code;
    private int maxUsage;
    private Date expiresOn;

    //mandatory fileds initialisation
    private CouponBuilder(String code) {
      this.code = code;
    }

    public static CouponBuilder aCoupon(String code) {
      return new CouponBuilder(code);
    }

    public CouponBuilder withMaxUsage(int maxUsage) {
      this.maxUsage = maxUsage;
      return this;
    }

    public CouponBuilder withExpiresOn(Date expiresOn) {
      this.expiresOn = expiresOn;
      return this;
    }

    public Coupon build() {
      Coupon coupon = new Coupon(code);
      coupon.setMaxUsage(maxUsage);
      coupon.setExpiresOn(expiresOn);
      return coupon;
    }

  }

}
