package com.migros.CourierTracking.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "Courier")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder
@Data
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courierId;

    @Column(name = "lng")
    private double lng;

    @Column(name = "lat")
    private double lat;

    @Column(name = "totalTravelDistance")
    private double totalTravelDistance=0.0;


}
