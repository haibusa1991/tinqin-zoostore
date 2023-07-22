package com.tinqin.zoostore.api.operations.item.updateArchivedStatus;

import com.tinqin.zoostore.api.base.ProcessorResult;
import com.tinqin.zoostore.api.operations.item.BaseEditItemResult;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@SuperBuilder
public class UpdateArchivedStatusResult extends BaseEditItemResult implements ProcessorResult {

//    private UUID id;
//    private String title;
//    private String description;
//    private UUID vendorId;
//    private UUID[] multimedia;
//    private UUID[] tags;
//    private Boolean isArchived;
}
