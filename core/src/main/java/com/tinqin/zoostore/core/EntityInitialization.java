package com.tinqin.zoostore.core;

import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component

public class EntityInitialization implements CommandLineRunner {
    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    private final VendorRepository vendorRepository;

    public EntityInitialization(ItemRepository itemRepository, TagRepository tagRepository, VendorRepository vendorRepository) {
        this.itemRepository = itemRepository;
        this.tagRepository = tagRepository;
        this.vendorRepository = vendorRepository;
    }


    @Override
    public void run(String... args) {

        this.initTags();
        this.initVendors();
        this.initItems();
    }

    private void initTags() {
        if (this.tagRepository.count() > 0) {
            return;
        }
        List<Tag> tags = List.of(Tag.builder().name("cat food").build(),
                Tag.builder().name("dog food").build(),
                Tag.builder().name("treat").build());

        this.tagRepository.saveAll(tags);
    }

    private void initVendors() {
        if (this.vendorRepository.count() > 0) {
            return;
        }

        List<Vendor> vendors = List.of(
                Vendor.builder().name("Whiskas").build(),
                Vendor.builder().name("Purina").build());

        this.vendorRepository.saveAll(vendors);
    }

    public void initItems() {
        if (this.itemRepository.count() > 0) {
            return;
        }

        Vendor whiskas = this.vendorRepository.findByName("Whiskas");
        Vendor purina = this.vendorRepository.findByName("Purina");

        Tag catFood = this.tagRepository.findTagByName("cat food");
        Tag dogFood = this.tagRepository.findTagByName("dog food");
        Tag treat = this.tagRepository.findTagByName("treat");

//        Item archived = Item.builder()
//                .title("Old dog food")
//                .description("This is an archived item")
//                .vendor(whiskas)
//                .build();
//        archived.setIsArchived(true);


        List<Item> items = List.of(
                Item.builder()
                        .title("Anti-Hairball 1")
                        .description("Reduces the risk of hairball forming.")
                        .vendor(whiskas)
                        .tags(Set.of(catFood))
                        .build(),
                Item.builder()
                        .title("Anti-Hairball 2")
                        .description("Reduces the risk of hairball forming.")
                        .vendor(whiskas)
                        .tags(Set.of(dogFood))
                        .build(),
                Item.builder()
                        .title("Anti-Hairball 3")
                        .description("Reduces the risk of hairball forming.")
                        .vendor(whiskas)
                        .tags(Set.of(treat))
                        .build(),
                Item.builder()
                        .title("Crunchy pockets 1")
                        .description("Crunchy treat with soft filling.")
                        .vendor(whiskas)
                        .tags(Set.of(catFood))
                        .build(),
                Item.builder()
                        .title("Crunchy pockets 2")
                        .description("Crunchy treat with soft filling.")
                        .vendor(whiskas)
                        .tags(Set.of(dogFood, treat))
                        .build(),
                Item.builder()
                        .title("Crunchy pockets 3")
                        .description("Crunchy treat with soft filling.")
                        .vendor(whiskas)
                        .tags(Set.of(catFood, treat))
                        .build()
        );

        this.itemRepository.saveAll(items);
    }
}
