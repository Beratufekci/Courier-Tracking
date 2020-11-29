package com.migros.CourierTracking.Entity;


import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Tracking")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder
@Data
public class Tracking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "courierId")
    private Long courierId;

    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;



}
