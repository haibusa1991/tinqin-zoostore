//package com.tinqin.zoostore.rest.controller;
//
//import com.tinqin.zoostore.api.request.item.*;
//import com.tinqin.zoostore.api.response.item.*;
//import com.tinqin.zoostore.core.exception.IdNotFoundException;
//import com.tinqin.zoostore.core.exception.VendorNotFoundException;
//import com.tinqin.zoostore.core.service.item.createItem.CreateItemService;
//import com.tinqin.zoostore.core.service.item.editItem.EditItemService;
//import com.tinqin.zoostore.core.service.item.getItem.GetItemService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/items")
//@RequiredArgsConstructor
//public class ItemController {
//    private final CreateItemService createItemService;
//    private final EditItemService editItemService;
//    private final GetItemService getItemService;
//
//    @Operation(description = "Returns list of all items", summary = "Get all items")
//    @ApiResponse(responseCode = "404", description = "no items found", content = @Content())
//    @ApiResponse(responseCode = "200", description = "list of all items")
//    @GetMapping()
//    public ResponseEntity<GetAllItemsResponse> getAllItems(@RequestParam(required = false,defaultValue = "false") Boolean includeArchived) {
//        return ResponseEntity.ok(this.getItemService.getAllItemsResponse(includeArchived));
//    }
//
//    @Operation(description = "Returns the requested item when requested by id.", summary = "Returns item by id.")
//    @ApiResponse(responseCode = "200", description = "Returns item.")
//    @ApiResponse(responseCode = "404", description = "No item found by the specified id.")
//    @GetMapping(path = "/{itemId}")
//    public ResponseEntity<GetItemByIdResponse> getItemById(@PathVariable String itemId) throws IdNotFoundException {
//        return ResponseEntity.ok(this.getItemService.getItemById(itemId));
//    }
//
//    @Operation(description = "Creates and returns item by input set of parameters.", summary = "Saves and returns.")
//    @ApiResponse(responseCode = "200", description = "Returns item.")
//    @ApiResponse(responseCode = "400", description = "Invalid input")
//    @PostMapping()
//    public ResponseEntity<CreateNewItemResponse> createNewItem(@RequestBody CreateNewItemRequest request) throws VendorNotFoundException {
//        return new ResponseEntity<>(this.createItemService.process(request), HttpStatus.CREATED);
//    }
//
//    @PatchMapping(path = "/{itemId}/title")
//    public ResponseEntity<EditItemTitleResponse> editItemTitle(@RequestBody EditItemTitleRequest request, @PathVariable String itemId) throws IdNotFoundException {
//        return ResponseEntity.ok(this.editItemService.editItemTitle(request, itemId));
//    }
//
//    @PatchMapping(path = "/{itemId}/description")
//    public ResponseEntity<EditItemDescriptionResponse> editItemDescription(@RequestBody EditItemDescriptionRequest request, @PathVariable String itemId) throws IdNotFoundException {
//        return ResponseEntity.ok(this.editItemService.editItemDescription(request, itemId));
//    }
//
//    @PatchMapping(path = "/{itemId}/vendor")
//    public ResponseEntity<EditItemVendorResponse> editItemVendor(@RequestBody EditItemVendorRequest request, @PathVariable String itemId) throws VendorNotFoundException, IdNotFoundException {
//        return ResponseEntity.ok(this.editItemService.editItemVendor(request, itemId));
//    }
//
//    @PatchMapping(path = "/{itemId}/multimedia")
//    public ResponseEntity<EditItemMultimediaResponse> editItemMultimedia(@RequestBody EditItemMultimediaRequest request, @PathVariable String itemId) throws IdNotFoundException {
//        return ResponseEntity.ok(this.editItemService.editItemMultimedia(request, itemId));
//    }
//
//    @PatchMapping(path = "/{itemId}/tags")
//    public ResponseEntity<EditItemTagsResponse> editItemTags(@RequestBody EditItemTagsRequest request, @PathVariable String itemId) throws IdNotFoundException {
//        return ResponseEntity.ok(this.editItemService.editItemTags(request, itemId));
//    }
//
//    @PatchMapping(path = "/{itemId}")
//    public ResponseEntity<String> updateArchivedStatus (@RequestParam Boolean isArchived, @PathVariable String itemId) throws IdNotFoundException {
//        this.editItemService.updateArchivedStatus(isArchived,itemId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//}
