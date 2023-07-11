package com.tinqin.zoostore.data.request.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class CreateNewItemRequest {

    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
