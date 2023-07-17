package com.tinqin.zoostore.api.operations.item.editItemTitle;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditItemTitleResponse implements ProcessorResult {

    private String id;
    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
