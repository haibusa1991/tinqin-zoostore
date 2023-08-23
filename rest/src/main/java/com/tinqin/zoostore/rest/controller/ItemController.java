package com.tinqin.zoostore.rest.controller;

import com.tinqin.restexport.annotation.RestExport;
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
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleInput;
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleOperation;
import com.tinqin.zoostore.api.operations.item.getItemByPartialTitle.GetItemByPartialTitleResult;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusOperation;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusInput;
import com.tinqin.zoostore.api.operations.item.updateArchivedStatus.UpdateArchivedStatusResult;
import com.tinqin.zoostore.core.exception.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Positive;
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
    private final GetItemByPartialTitleOperation getItemByPartialTitle;

    @Operation(description = "Returns list of all items.", summary = "Gets all items.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No items found.", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Items per page is less than 1 or page is less than 1.", content = @Content()),
            @ApiResponse(responseCode = "200", description = "List of all items.")})
    @RestExport
    @GetMapping
    public ResponseEntity<GetAllItemsResult> getAllItems(
            @RequestParam(required = false, defaultValue = "false") Boolean includeArchived,
            @RequestParam(required = false, defaultValue = "") @UUID(allowEmpty = true) String tag,
            @RequestParam(defaultValue = "2") Integer itemCount,
            @RequestParam(defaultValue = "1") Integer page
    ) {

        GetAllItemInput input = GetAllItemInput.builder()
                .shouldIncludeArchived(includeArchived)
                .tagId(tag.length() == 0 ? null : java.util.UUID.fromString(tag))
                .itemCount(itemCount)
                .page(page)
                .build();

        return ResponseEntity.ok(this.getAllItem.process(input));
    }
    @Operation(description = "Returns list of all items with partial match of the title.", summary = "Gets all items with partial title match.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No items found.", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Items per page is less than 1 or page is less than 1.", content = @Content()),
            @ApiResponse(responseCode = "200", description = "List of all items with partial title match.")})
    @RestExport
    @GetMapping(path = "/partial")
    public ResponseEntity<GetItemByPartialTitleResult> getItemByPartialTitle(
            @RequestParam String title,
            @RequestParam(defaultValue = "2") @Positive Integer itemCount,
            @RequestParam(defaultValue = "1") @Positive Integer page
    ) {
        GetItemByPartialTitleInput input = GetItemByPartialTitleInput.builder()
                .title(title)
                .itemCount(itemCount)
                .page(page)
                .build();

        return ResponseEntity.ok(this.getItemByPartialTitle.process(input));
    }


    @Operation(description = "Returns the requested item when requested by id.", summary = "Returns item by id.")
    @ApiResponse(responseCode = "200", description = "Returns item.")
    @ApiResponse(responseCode = "404", description = "No item found by the specified id.")
    @GetMapping(path = "/{itemId}")
    public ResponseEntity<GetItemByIdResult> getItemById(@PathVariable @UUID String itemId) {
        return ResponseEntity.ok(this.getItemById.process(GetItemByIdInput.builder().id(java.util.UUID.fromString(itemId)).build()));
    }


    @Operation(description = "Creates and returns an item by input set of parameters.", summary = "Saves and returns item data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Vendor/Tag/Multimedia id is invalid.", content = @Content()),
            @ApiResponse(responseCode = "200", description = "Returns the item with matching id.")})
    @PostMapping()
    @RestExport
    public ResponseEntity<CreateItemResult> createItem(@RequestBody CreateItemInput request) {
        return new ResponseEntity<>(this.createItem.process(request), HttpStatus.CREATED);
    }

    @Operation(description = "Edits and returns an by id.", summary = "Edits and returns item data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Item/Vendor/Tag/Multimedia with specified id not found.", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Item/Vendor/Tag/Multimedia id is invalid.", content = @Content()),
            @ApiResponse(responseCode = "200", description = "Returns the item with matching id.")})
    @RestExport
    @PutMapping(path = "/{itemId}")
    public ResponseEntity<EditItemResult> editItem(@RequestBody EditItemInput input, @PathVariable @UUID String itemId) {
        input.setId(itemId);
        return ResponseEntity.ok(this.editItem.process(input));
    }
}
