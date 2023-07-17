package com.tinqin.zoostore.api.request.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class EditItemTitleRequest {
    private String title;
}
