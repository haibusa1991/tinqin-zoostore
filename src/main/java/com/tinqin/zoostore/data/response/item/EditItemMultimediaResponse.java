package com.tinqin.zoostore.data.response.item;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditItemMultimediaResponse {

    private String id;
    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
