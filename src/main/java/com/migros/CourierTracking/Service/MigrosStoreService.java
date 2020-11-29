package com.migros.CourierTracking.Service;

import com.migros.CourierTracking.Entity.MigrosStore;
import com.migros.CourierTracking.Repository.MigrosStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MigrosStoreService {

    MigrosStoreRepository migrosStoreRepository;

    public MigrosStoreService(MigrosStoreRepository migrosStoreRepository){
        this.migrosStoreRepository = migrosStoreRepository;
    }



    public Iterable<MigrosStore> list() {

        return migrosStoreRepository.findAll();
    }

    public MigrosStore save(MigrosStore migrosStore){

        return migrosStoreRepository.save(migrosStore);
    }

    public Iterable<MigrosStore> save(List<MigrosStore> migrosStores){

        return migrosStoreRepository.saveAll(migrosStores);
    }

}
