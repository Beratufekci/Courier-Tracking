package com.migros.CourierTracking.Repository;

import com.migros.CourierTracking.Entity.MigrosStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MigrosStoreRepository extends JpaRepository<MigrosStore,Long> {
}
