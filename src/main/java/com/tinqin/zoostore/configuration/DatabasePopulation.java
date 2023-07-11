package com.tinqin.zoostore.configuration;

import com.tinqin.zoostore.services.item.ItemService;
import com.tinqin.zoostore.services.tag.TagService;
import com.tinqin.zoostore.services.vendor.VendorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulation implements CommandLineRunner {

    private final ItemService itemService;
    private final VendorService vendorService;
    private final TagService tagService;

    public DatabasePopulation(ItemService itemService, VendorService vendorService, TagService tagService) {
        this.itemService = itemService;
        this.vendorService = vendorService;
        this.tagService = tagService;
    }

    @Override
    public void run(String... args){
        this.vendorService.initVendors();
        this.tagService.initTags();
        this.itemService.initItems();
    }
}
