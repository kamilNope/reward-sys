package com.edge1.kamil.nope.rewardsys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER") public
class Customer {
    @Id @Column(name = "ID_C", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

}
