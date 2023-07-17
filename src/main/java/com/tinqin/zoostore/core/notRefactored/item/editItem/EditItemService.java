package com.tinqin.zoostore.core.notRefactored.item.editItem;

import com.tinqin.zoostore.api.request.item.*;
import com.tinqin.zoostore.api.response.item.*;
import com.tinqin.zoostore.core.exception.IdNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;

public interface EditItemService {

    EditItemTitleResponse editItemTitle(EditItemTitleRequest request, String itemId) throws IdNotFoundException;

    EditItemDescriptionResponse editItemDescription(EditItemDescriptionRequest request, String itemId) throws IdNotFoundException;

    EditItemVendorResponse editItemVendor(EditItemVendorRequest request, String itemId) throws IdNotFoundException, VendorNotFoundException;

    EditItemMultimediaResponse editItemMultimedia(EditItemMultimediaRequest request, String itemId) throws IdNotFoundException;

    EditItemTagsResponse editItemTags(EditItemTagsRequest request, String itemId) throws IdNotFoundException;

    void updateArchivedStatus(Boolean isArchived, String itemId) throws IdNotFoundException;
}
