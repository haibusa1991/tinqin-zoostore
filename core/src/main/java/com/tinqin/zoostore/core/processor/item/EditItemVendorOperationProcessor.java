package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorOperation;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorInput;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorResult;
import com.tinqin.zoostore.core.UuidValidator;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.entity.Vendor;
import com.tinqin.zoostore.persistence.repository.ItemRepository;
import com.tinqin.zoostore.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemVendorOperationProcessor implements EditItemVendorOperation {
    private final VendorRepository vendorRepository;
    private final ItemRepository itemRepository;

    @Override
    public EditItemVendorResult process(EditItemVendorInput input) {
        Item item = this.itemRepository
                .findById(input.getId())
                .orElseThrow(() -> new ItemNotFoundException(input.getId()));

        Vendor vendor = this.vendorRepository
                .findById(input.getVendorId())
                .orElseThrow(() -> new VendorNotFoundException(input.getVendorId()));

        item.setVendor(vendor);

        Item persisted = this.itemRepository.save(item);

        return EditItemVendorResult.builder()
                .id(persisted.getId())
                .title(persisted.getTitle())
                .description(persisted.getDescription())
                .vendorId(persisted.getVendor().getId())
                .multimedia(persisted.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
                .tags(persisted.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
                .build();
    }
}
