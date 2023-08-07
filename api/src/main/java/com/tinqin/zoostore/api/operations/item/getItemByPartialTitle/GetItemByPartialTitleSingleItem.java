package com.tinqin.zoostore.api.operations.item.getItemByPartialTitle;

import com.tinqin.zoostore.api.operations.item.BaseEditItemResult;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
public class GetItemByPartialTitleSingleItem extends BaseEditItemResult {
    public GetItemByPartialTitleSingleItem() {
    }

//    private UUID id;
//    private String title;
//    private String description;
//    private UUID vendorId;
//    private UUID[] multimedia;
//    private UUID[] tags;
//    private Boolean isArchived;
}
