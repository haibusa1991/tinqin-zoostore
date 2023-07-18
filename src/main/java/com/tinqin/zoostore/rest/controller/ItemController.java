package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.item.createItem.CreateItemOperation;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemRequest;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemResponse;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionOperation;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionRequest;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionResponse;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaOperation;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaRequest;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaResponse;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagOperation;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagRequest;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagResponse;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleOperation;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleRequest;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleResponse;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorOperation;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorRequest;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorResponse;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperation;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemRequest;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResponse;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdOperation;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdRequest;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResponse;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusOperation;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusRequest;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusResponse;
import com.tinqin.zoostore.core.exception.*;
import com.tinqin.zoostore.core.processor.item.UpdateArchivedStatusOperationProcessor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
@RequiredArgsConstructor
public class ItemController {
    private final CreateItemOperation createItem;
    private final GetAllItemOperation getAllItem;
    private final GetItemByIdOperation getItemById;
    private final EditItemTitleOperation editItemTitle;
    private final EditItemDescriptionOperation editItemDescription;
    private final EditItemVendorOperation editItemVendor;
    private final EditItemMultimediaOperation editItemMultimedia;
    private final EditItemTagOperation editItemTag;
    private final UpdateArchivedStatusOperation updateArchivedStatus;

    @Operation(description = "Returns list of all items", summary = "Get all items")
    @ApiResponse(responseCode = "404", description = "no items found", content = @Content())
    @ApiResponse(responseCode = "200", description = "list of all items")
    @GetMapping()
    public ResponseEntity<GetAllItemsResponse> getAllItems(@RequestParam(required = false, defaultValue = "false") Boolean includeArchived) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException, InvalidUuidException, ItemNotFoundException {
        return ResponseEntity.ok(this.getAllItem.process(GetAllItemRequest.builder().shouldIncludeArchived(includeArchived).build()));
    }

    @Operation(description = "Returns the requested item when requested by id.", summary = "Returns item by id.")
    @ApiResponse(responseCode = "200", description = "Returns item.")
    @ApiResponse(responseCode = "404", description = "No item found by the specified id.")
    @GetMapping(path = "/{itemId}")
    public ResponseEntity<GetItemByIdResponse> getItemById(@PathVariable String itemId) {
        return ResponseEntity.ok(this.getItemById.process(GetItemByIdRequest.builder().id(itemId).build()));
    }

    @Operation(description = "Creates and returns item by input set of parameters.", summary = "Saves and returns.")
    @ApiResponse(responseCode = "200", description = "Returns item.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping()
    public ResponseEntity<CreateItemResponse> createItem(@RequestBody CreateItemRequest request) {
        return new ResponseEntity<>(this.createItem.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/edit-title")
    public ResponseEntity<EditItemTitleResponse> editItemTitle(@RequestBody EditItemTitleRequest request) {
        return ResponseEntity.ok(this.editItemTitle.process(request));
    }

    @PatchMapping(path = "/edit-description")
    public ResponseEntity<EditItemDescriptionResponse> editItemDescription(@RequestBody EditItemDescriptionRequest request) {
        return ResponseEntity.ok(this.editItemDescription.process(request));
    }

    @PatchMapping(path = "/edit-vendor")
    public ResponseEntity<EditItemVendorResponse> editItemVendor(@RequestBody EditItemVendorRequest request) {
        return ResponseEntity.ok(this.editItemVendor.process(request));
    }

    @PatchMapping(path = "/edit-multimedia")
    public ResponseEntity<EditItemMultimediaResponse> editItemMultimedia(@RequestBody EditItemMultimediaRequest request) {
        return ResponseEntity.ok(this.editItemMultimedia.process(request));
    }

    @PatchMapping(path = "/edit-tag")
    public ResponseEntity<EditItemTagResponse> editItemTags(@RequestBody EditItemTagRequest request) {
        return ResponseEntity.ok(this.editItemTag.process(request));
    }

    @PatchMapping(path = "/archive")
    public ResponseEntity<UpdateArchivedStatusResponse> updateArchivedStatus(@RequestBody UpdateArchivedStatusRequest request) {
        return ResponseEntity.ok(this.updateArchivedStatus.process(request));
    }

}
