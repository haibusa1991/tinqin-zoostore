package com.tinqin.zoostore.core.notRefactored.item.editItem;

import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionRequest;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionResponse;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaRequest;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaResponse;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagRequest;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagResponse;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleRequest;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleResponse;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorRequest;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorResponse;
import com.tinqin.zoostore.core.exception.IdNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;

public interface EditItemService {

    EditItemTitleResponse editItemTitle(EditItemTitleRequest request, String itemId) throws IdNotFoundException;

    EditItemDescriptionResponse editItemDescription(EditItemDescriptionRequest request, String itemId) throws IdNotFoundException;

    EditItemVendorResponse editItemVendor(EditItemVendorRequest request, String itemId) throws IdNotFoundException, VendorNotFoundException;

    EditItemMultimediaResponse editItemMultimedia(EditItemMultimediaRequest request, String itemId) throws IdNotFoundException;

    EditItemTagResponse editItemTags(EditItemTagRequest request, String itemId) throws IdNotFoundException;

    void updateArchivedStatus(Boolean isArchived, String itemId) throws IdNotFoundException;
}
