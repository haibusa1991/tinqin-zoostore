package com.tinqin.zoostore.initialzation;

import com.tinqin.zoostore.data.entity.Item;
import com.tinqin.zoostore.data.entity.Tag;
import com.tinqin.zoostore.data.entity.Vendor;
import com.tinqin.zoostore.repository.ItemRepository;
import com.tinqin.zoostore.repository.MultimediaRepository;
import com.tinqin.zoostore.repository.TagRepository;
import com.tinqin.zoostore.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
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
                Tag.builder().name("treat").build());

        this.tagRepository.saveAll(tags);
    }

    public void initItems() {
        if (this.itemRepository.count() > 0) {
            return;
        }

        Vendor whiskas = this.vendorRepository.findByName("Whiskas");
        Tag catFood = this.tagRepository.findTagByName("cat food");
        Tag treat = this.tagRepository.findTagByName("treat");

        List<Item> items = List.of(Item.builder()
                        .title("Anti-Hairball")
                        .description("Reduces the risk of hairball forming.")
                        .vendorId(whiskas)
                        .tags(Set.of(catFood))
                        .build(),
                Item.builder()
                        .title("Crunchy pockets")
                        .description("Crunchy treat with soft filling.")
                        .vendorId(whiskas)
                        .tags(Set.of(catFood, treat))
                        .build()
        );

        this.itemRepository.saveAll(items);
    }

    private void initVendors() {
        if (this.vendorRepository.count() > 0) {
            return;
        }
        this.vendorRepository.save(Vendor.builder().name("Whiskas").build());
    }
}
