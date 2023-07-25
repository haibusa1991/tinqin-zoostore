package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.item.createItem.CreateItemOperation;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemInput;
import com.tinqin.zoostore.api.operations.item.createItem.CreateItemResult;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemInput;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemOperation;
import com.tinqin.zoostore.api.operations.item.editItem.EditItemResult;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionOperation;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionInput;
import com.tinqin.zoostore.api.operations.item.editItemDescription.EditItemDescriptionResult;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaOperation;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaInput;
import com.tinqin.zoostore.api.operations.item.editItemMultimedia.EditItemMultimediaResult;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagOperation;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagInput;
import com.tinqin.zoostore.api.operations.item.editItemTag.EditItemTagResult;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleOperation;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleInput;
import com.tinqin.zoostore.api.operations.item.editItemTitle.EditItemTitleResult;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorOperation;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorInput;
import com.tinqin.zoostore.api.operations.item.editItemVendor.EditItemVendorResult;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemOperation;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemInput;
import com.tinqin.zoostore.api.operations.item.getAllItem.GetAllItemsResult;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdOperation;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdInput;
import com.tinqin.zoostore.api.operations.item.getItemById.GetItemByIdResult;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusOperation;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusInput;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusResult;
import com.tinqin.zoostore.core.exception.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
@RequiredArgsConstructor
@Validated
public class ItemController {
    private final CreateItemOperation createItem;
    private final GetAllItemOperation getAllItem;
    private final GetItemByIdOperation getItemById;
    private final EditItemOperation editItem;
//    private final EditItemTitleOperation editItemTitle;
//    private final EditItemDescriptionOperation editItemDescription;
//    private final EditItemVendorOperation editItemVendor;
//    private final EditItemMultimediaOperation editItemMultimedia;
//    private final EditItemTagOperation editItemTag;
//    private final UpdateArchivedStatusOperation updateArchivedStatus;

    @Operation(description = "Returns list of all items", summary = "Get all items")
    @ApiResponse(responseCode = "404", description = "no items found", content = @Content())
    @ApiResponse(responseCode = "200", description = "list of all items")
    @GetMapping()
    public ResponseEntity<GetAllItemsResult> getAllItems(@RequestParam(required = false, defaultValue = "false") Boolean includeArchived) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException, ItemNotFoundException {
        return ResponseEntity.ok(this.getAllItem.process(GetAllItemInput.builder().shouldIncludeArchived(includeArchived).build()));
    }

    @Operation(description = "Returns the requested item when requested by id.", summary = "Returns item by id.")
    @ApiResponse(responseCode = "200", description = "Returns item.")
    @ApiResponse(responseCode = "404", description = "No item found by the specified id.")
    @GetMapping(path = "/{itemId}")
    public ResponseEntity<GetItemByIdResult> getItemById(@PathVariable @UUID String itemId) {
        return ResponseEntity.ok(this.getItemById.process(GetItemByIdInput.builder().id(java.util.UUID.fromString(itemId)).build()));
    }

    @Operation(description = "Creates and returns item by input set of parameters.", summary = "Saves and returns.")
    @ApiResponse(responseCode = "200", description = "Returns item.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping()
    public ResponseEntity<CreateItemResult> createItem(@RequestBody CreateItemInput request) {
        return new ResponseEntity<>(this.createItem.process(request), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{itemId}")
    public ResponseEntity<EditItemResult> editItem(@RequestBody EditItemInput input, @PathVariable @UUID String itemId) {
        input.setId(itemId);
        return ResponseEntity.ok(this.editItem.process(input));
    }

//    @PatchMapping(path = "/{itemId}/edit-title")
//    public ResponseEntity<EditItemTitleResult> editItemTitle(@RequestBody EditItemTitleInput request, @PathVariable @UUID String itemId) {
//        request.setId(java.util.UUID.fromString(itemId));
//        return ResponseEntity.ok(this.editItemTitle.process(request));
//    }
//
//    @PatchMapping(path = "/{itemId}/edit-description")
//    public ResponseEntity<EditItemDescriptionResult> editItemDescription(@RequestBody EditItemDescriptionInput request, @PathVariable @UUID String itemId) {
//        request.setId(java.util.UUID.fromString(itemId));
//        return ResponseEntity.ok(this.editItemDescription.process(request));
//    }
//
//    @PatchMapping(path = "/{itemId}/edit-vendor")
//    public ResponseEntity<EditItemVendorResult> editItemVendor(@RequestBody EditItemVendorInput request, @PathVariable @UUID String itemId) {
//        request.setId(java.util.UUID.fromString(itemId));
//        return ResponseEntity.ok(this.editItemVendor.process(request));
//    }
//
//    @PatchMapping(path = "/{itemId}/edit-multimedia")
//    public ResponseEntity<EditItemMultimediaResult> editItemMultimedia(@RequestBody EditItemMultimediaInput request, @PathVariable @UUID String itemId) {
//        request.setId(java.util.UUID.fromString(itemId));
//        return ResponseEntity.ok(this.editItemMultimedia.process(request));
//    }
//
//    @PatchMapping(path = "/{itemId}/edit-tag")
//    public ResponseEntity<EditItemTagResult> editItemTags(@RequestBody EditItemTagInput request, @PathVariable @UUID String itemId) {
//        request.setId(java.util.UUID.fromString(itemId));
//        return ResponseEntity.ok(this.editItemTag.process(request));
//    }
//
//    @PatchMapping(path = "/{itemId}/archive")
//    public ResponseEntity<UpdateArchivedStatusResult> updateArchivedStatus(@RequestBody UpdateArchivedStatusInput request, @PathVariable @UUID String itemId) {
//        request.setId(java.util.UUID.fromString(itemId));
//        return ResponseEntity.ok(this.updateArchivedStatus.process(request));
//    }

}
