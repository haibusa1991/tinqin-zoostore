package com.tinqin.zoostore.api.operations.item.getItemByPartialTitle;

import com.tinqin.zoostore.api.base.ProcessorResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemByPartialTitleResult implements ProcessorResult {

    private Set<GetItemByPartialTitleSingleItem> items;
}
