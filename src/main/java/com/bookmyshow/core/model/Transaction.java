package com.bookmyshow.core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "transactions")
public class Transaction extends Auditable {


  @ManyToOne
  private Booking booking;

  private TransactionStatus status = TransactionStatus.NEW;

  private String paymentGateway;

  private double amount;
}
