package com.tinqin.zoostore.core.processor.item;

import com.tinqin.zoostore.api.operations.item.BaseEditItemResult;
import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Multimedia;
import com.tinqin.zoostore.persistence.entity.Tag;

import java.util.UUID;

public class Items {
//    public <T extends BaseEditItemResult> T mapItemToEditItemProcessorResult (Item item){

//        return (T) T.builder()
//                .id(item.getId())
//                .title(item.getTitle())
//                .description(item.getDescription())
//                .vendorId(item.getVendor().getId())
//                .multimedia(item.getMultimedia().stream().map(Multimedia::getId).toArray(UUID[]::new))
//                .tags(item.getTags().stream().map(Tag::getId).toArray(UUID[]::new))
//                .build();
//    }
}
