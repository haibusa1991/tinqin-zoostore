package com.tinqin.zoostore.api.response.item;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemByIdResponse {

    private String id;
    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
    private Boolean isArchived;
}
