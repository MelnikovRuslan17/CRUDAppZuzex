package com.zuzex.crudappzuzex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "houses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "h_adress")
    private String adress;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;


}
