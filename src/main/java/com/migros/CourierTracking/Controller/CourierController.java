package com.migros.CourierTracking.Controller;

import com.migros.CourierTracking.Entity.Courier;
import com.migros.CourierTracking.Entity.Tracking;
import com.migros.CourierTracking.Service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    CourierService courierService;

    @PostMapping
    public ResponseEntity<Tracking> getTracking(@RequestBody Courier courier){

        return ResponseEntity.ok(courierService.save(courier));
    }

    @GetMapping ("/totalTravelDistance/{courierId}")
    public ResponseEntity<Double> getTotalTravelDistance(@PathVariable Long courierId){

        return ResponseEntity.ok(courierService.getTotalTravelDistance(courierId));

    }

}
