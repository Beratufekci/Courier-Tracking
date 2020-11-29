package com.migros.CourierTracking.Entity;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@EqualsAndHashCode(of = {"id"})
@Table(name = "MigrosStore")
public class MigrosStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;


}
