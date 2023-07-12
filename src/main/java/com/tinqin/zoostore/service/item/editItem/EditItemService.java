package com.tinqin.zoostore.service.item.editItem;

import com.tinqin.zoostore.data.request.item.*;
import com.tinqin.zoostore.data.response.item.*;
import com.tinqin.zoostore.exception.ItemNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;

public interface EditItemService {

    EditItemTitleResponse editItemTitle(EditItemTitleRequest request, String itemId) throws ItemNotFoundException;

    EditItemDescriptionResponse editItemDescription(EditItemDescriptionRequest request, String itemId) throws ItemNotFoundException;

    EditItemVendorResponse editItemVendor(EditItemVendorRequest request, String itemId) throws ItemNotFoundException, VendorNotFoundException;

    EditItemMultimediaResponse editItemMultimedia(EditItemMultimediaRequest request, String itemId) throws ItemNotFoundException;

    EditItemTagsResponse editItemTags(EditItemTagsRequest request, String itemId) throws ItemNotFoundException;
}
