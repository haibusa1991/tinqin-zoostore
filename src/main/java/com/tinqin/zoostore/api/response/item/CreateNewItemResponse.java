package com.tinqin.zoostore.api.response.item;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewItemResponse implements ProcessorResult {

    private String id;
    private String title;
    private String description;
    private String vendorId;
    private String[] multimedia;
    private String[] tags;
}
