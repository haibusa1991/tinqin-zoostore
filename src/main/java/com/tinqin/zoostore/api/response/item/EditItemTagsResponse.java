package com.tinqin.zoostore.api.response.item;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditItemTagsResponse {

    private String id;
    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
