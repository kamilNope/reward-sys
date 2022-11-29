package com.edge1.kamil.nope.rewardsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION") public
class Transaction {
    @Id
    @Column(name = "ID_T")
    private Long id;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ID_C")
    private Customer customer;

}
