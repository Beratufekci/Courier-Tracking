package com.migros.CourierTracking.Service;

import com.migros.CourierTracking.Entity.Courier;
import com.migros.CourierTracking.Entity.MigrosStore;
import com.migros.CourierTracking.Entity.Tracking;
import com.migros.CourierTracking.Repository.CourierRepository;
import com.migros.CourierTracking.Repository.MigrosStoreRepository;
import com.migros.CourierTracking.Repository.TrackingRepository;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourierService {

    private final CourierRepository courierRepository;
    private final MigrosStoreService migrosStoreService;
    private final TrackingRepository trackingRepository;
    private double travelDistance = 0.0;



    public CourierService(CourierRepository courierRepository, MigrosStoreService migrosStoreService , TrackingRepository trackingRepository) {
        this.courierRepository = courierRepository;
        this.migrosStoreService = migrosStoreService;
        this.trackingRepository = trackingRepository;
    }

    public Tracking save(Courier courier) {


        Long storeId = 0L;
        Date date = new Date();
        Iterable<MigrosStore> migrosStores = migrosStoreService.list();
        Tracking newTracking = new Tracking();
        boolean flag = true;


        for(MigrosStore store : migrosStores){

            double distance = this.distance(courier.getLat(), store.getLat(), courier.getLng(), store.getLng());

            if(distance < 100.0){

                travelDistance = distance;
                storeId = store.getId();
                break;

            }


        }

        List<Tracking> trackingList = trackingRepository.getTrackingByCourierId(courier.getCourierId());

        for(Tracking tracking : trackingList){
            Date trackingTime = tracking.getTime();
            long diffsec = (date.getTime() - trackingTime.getTime())/1000;

            if(diffsec > 60){

                flag=false;
                break;

            }
        }

        if(flag){

            newTracking.setCourierId(courier.getCourierId());
            newTracking.setStoreId(storeId);
            newTracking.setTime(date);

            trackingRepository.save(newTracking);

        }


        return newTracking;
    }

    public double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        return distance;
    }


    public Double getTotalTravelDistance(Long courierId){

        Courier courier = courierRepository.getOne(courierId);

        courier.setTotalTravelDistance(courier.getTotalTravelDistance() + travelDistance);


        return courier.getTotalTravelDistance();
    }



}
