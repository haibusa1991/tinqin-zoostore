package com.tinqin.zoostore.restexport;

import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdInput;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestExport {

    @RequestLine("GET /items/{itemId}")
    GetItemByIdResult getItemById(@Param("itemId") String itemId);
}
