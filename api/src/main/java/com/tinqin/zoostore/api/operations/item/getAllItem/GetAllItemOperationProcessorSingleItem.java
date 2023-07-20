package com.tinqin.zoostore.api.operations.item.getAllItem;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllItemOperationProcessorSingleItem {
    private UUID id;
    private String title;
    private String description;
    private UUID vendorId;
    private UUID[] multimedia;
    private UUID[] tags;
    private Boolean isArchived;
}
