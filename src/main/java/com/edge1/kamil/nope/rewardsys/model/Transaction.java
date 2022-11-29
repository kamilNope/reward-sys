package com.edge1.kamil.nope.rewardsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @Column(name = "transactionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}

