package com.tinqin.zoostore.configuration;

import com.tinqin.zoostore.services.item.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulation implements CommandLineRunner {

    private final ItemService itemService;

    public DatabasePopulation(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.itemService.initDatabase();
    }
}
