package com.tinqin.zoostore.requests.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewItemRequest {

    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
