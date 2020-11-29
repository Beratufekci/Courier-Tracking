package com.migros.CourierTracking.Repository;


import com.migros.CourierTracking.Entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier,Long> {
}
