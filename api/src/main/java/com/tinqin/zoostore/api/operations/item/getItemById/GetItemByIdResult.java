package com.tinqin.zoostore.api.operations.item.getItemById;

import com.tinqin.zoostore.api.base.ProcessorResult;
import com.tinqin.zoostore.api.operations.item.BaseEditItemResult;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//public class GetItemByIdResult extends BaseEditItemResult implements ProcessorResult {
public class GetItemByIdResult implements ProcessorResult {


    private UUID id;
    private String title;
    private String description;
    private UUID vendorId;
    private UUID[] multimedia;
    private UUID[] tags;
    private Boolean isArchived;
}
