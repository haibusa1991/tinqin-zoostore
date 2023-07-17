package com.tinqin.zoostore.core.processor.tag;

import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagOperation;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagRequest;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagResponse;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.persistence.entity.Tag;
import com.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTagOperationProcessor implements CreateTagOperation {
    private final TagRepository tagRepository;

    @Override
    public CreateTagResponse process(CreateTagRequest request) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException {
        Tag persisted = this.tagRepository.save(Tag.builder().name(request.getName()).build());

        return CreateTagResponse.builder()
                .id(persisted.getId())
                .name(persisted.getName())
                .build();
    }
}
