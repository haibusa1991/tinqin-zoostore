package com.tinqin.zoostore.restexport;

import com.tinqin.zoostore.api.operations.item.createItem.CreateItemInput;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemResult;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemInput;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemResult;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResult;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResult;
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleResult;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResult;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagResult;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({
    "Content-Type: application/json"
})
public interface ZooStoreRestExport {

    @RequestLine("GET /tags")
    GetAllTagResult getAllTags();

    @RequestLine("GET /tags/{tagId}")
    GetTagByIdResult getTagById(@Param("tagId") String tagId);

    @RequestLine("GET /multimedia")
    GetAllMultimediaResult getAllMultimedia();

    @RequestLine("GET /multimedia/{multimediaId}")
    GetMultimediaByIdResult getMultimediaById(@Param("multimediaId") String multimediaId);

    @RequestLine("POST /multimedia")
    CreateMultimediaResult createMultimedia(CreateMultimediaInput request);

    @RequestLine("PATCH /multimedia/edit")
    EditMultimediaResult editMultimedia(EditMultimediaInput request);

    @RequestLine("GET /items?includeArchived={includeArchived}&tag={tag}&itemCount={itemCount}&page={page}")
    GetAllItemsResult getAllItems(@Param("includeArchived") Boolean includeArchived,
        @Param("tag") String tag,
        @Param("itemCount") Integer itemCount,
        @Param("page") Integer page);

    @RequestLine("GET /items/partial?title={title}&itemCount={itemCount}&page={page}")
    GetItemByPartialTitleResult getItemByPartialTitle(@Param("title") String title, @Param("itemCount") Integer itemCount, @Param("page") Integer page);

    @RequestLine("GET /items/{itemId}")
    GetItemByIdResult getItemById(@Param("itemId") String itemId);

    @RequestLine("POST /items")
    CreateItemResult createItem(CreateItemInput request);

    @RequestLine("PUT /items/{itemId}")
    EditItemResult editItem(@Param("itemId") String itemId, EditItemInput input);
}
