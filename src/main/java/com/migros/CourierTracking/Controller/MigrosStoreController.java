package com.migros.CourierTracking.Controller;

import com.migros.CourierTracking.Entity.MigrosStore;
import com.migros.CourierTracking.Service.MigrosStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/migrosStore")
public class MigrosStoreController {

    @Autowired
    private MigrosStoreService migrosStoreService;

    @GetMapping("/list")
    public Iterable<MigrosStore> list(){

        return migrosStoreService.list();
    }
}
