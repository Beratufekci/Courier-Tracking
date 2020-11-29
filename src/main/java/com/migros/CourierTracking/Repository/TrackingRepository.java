package com.migros.CourierTracking.Repository;

import com.migros.CourierTracking.Entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking,Long> {

    List<Tracking> getTrackingByCourierId(Long courierId);

}
