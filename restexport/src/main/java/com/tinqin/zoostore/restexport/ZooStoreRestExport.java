package com.tinqin.zoostore.restexport;

import com.tinqin.zoostore.api.operations.item.createItem.CreateItemInput;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemResult;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemInput;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemResult;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionInput;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionResult;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaInput;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaResult;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagInput;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagResult;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleInput;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleResult;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorInput;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorResult;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResult;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResult;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusInput;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusResult;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResult;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagInput;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagResult;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagInput;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagResult;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagResult;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdResult;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorInput;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResult;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorResponseResult;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorResult;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestExport {

    //Item
    @RequestLine("GET /items")
    GetAllItemsResult getAllItems();

    @RequestLine("GET /items/{itemId}")
    GetItemByIdResult getItemById(@Param("itemId") String itemId);

    @RequestLine("POST /items")
    CreateItemResult createItem(@Param CreateItemInput input);

    @RequestLine("PUT /items/{itemId}")
    EditItemResult editItem(@Param("itemId") String itemId, @Param EditItemInput input);

//    @RequestLine("PATCH /items/{itemId}/edit-title")
//    EditItemTitleResult editItemTitle(@Param("itemId") String itemId, @Param EditItemTitleInput input);
//
//    @RequestLine("PATCH /items/{itemId}/edit-description")
//    EditItemDescriptionResult editItemDescription(@Param("itemId") String itemId, @Param EditItemDescriptionInput input);
//
//    @RequestLine("PATCH /items/{itemId}/edit-vendor")
//    EditItemVendorResult editItemVendor(@Param("itemId") String itemId, @Param EditItemVendorInput input);
//
//    @RequestLine("PATCH /items/{itemId}/edit-multimedia")
//    EditItemMultimediaResult editItemMultimedia(@Param("itemId") String itemId, @Param EditItemMultimediaInput input);
//
//    @RequestLine("PATCH /items/{itemId}/edit-tag")
//    EditItemTagResult editItemTags(@Param("itemId") String itemId, @Param EditItemTagInput input);
//
//    @RequestLine("PATCH /items/{itemId}/archive")
//    UpdateArchivedStatusResult updateArchivedStatus(@Param("itemId") String itemId, @Param UpdateArchivedStatusInput input);

    //Multimedia
    @RequestLine("GET /multimedia")
    GetAllMultimediaResult getAllMultimedia();

    @RequestLine("GET /multimedia/{multimediaId}")
    GetMultimediaByIdResult getMultimediaById(@Param("multimediaId") String multimediaId);

    @RequestLine("POST /multimedia")
    CreateMultimediaResult createMultimedia(@Param CreateMultimediaInput input);

    @RequestLine("PATCH /multimedia/{multimediaId}")
    EditMultimediaResult editMultimedia(@Param("multimediaId") String multimediaId, @Param EditMultimediaInput input);

    //Tag
    @RequestLine("GET /tags")
    GetAllTagResult getAllTags();

    @RequestLine("GET /tags/{tagId}")
    GetTagByIdResult getTagById(@Param("tagId") String tagId);

    @RequestLine("POST /tags")
    CreateTagResult createTag(@Param CreateTagInput input);

    @RequestLine("PATCH /tags/{tagId}")
    EditTagResult editTag(@Param("tagId") String tagId, @Param EditTagInput input);

    //Vendor
    @RequestLine("GET /vendors")
    GetAllVendorResult getAllVendors();

    @RequestLine("GET /vendors/{vendorId}")
    GetVendorByIdResult getVendorById(@Param("vendorId") String vendorId);

    @RequestLine("POST /vendors")
    CreateVendorResult createVendor(@Param CreateVendorInput input);

    @RequestLine("PATCH /vendors/{vendorId}")
    EditVendorResponseResult editVendor(@Param("vendorId") String vendorId, @Param EditTagInput input);

}
