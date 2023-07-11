package com.tinqin.zoostore.controller;

import com.tinqin.zoostore.dto.item.*;
import com.tinqin.zoostore.data.request.item.CreateNewItemRequest;
import com.tinqin.zoostore.data.response.item.CreateNewItemResponse;
import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import com.tinqin.zoostore.data.response.item.GetAllItemsResponse;
import com.tinqin.zoostore.service.item.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(description = "Returns list of all items", summary = "Get all items")
    @ApiResponse(responseCode = "404", description = "no items found", content = @Content(examples = {}))
    @ApiResponse(responseCode = "200", description = "list of all items")
    @GetMapping()
    public ResponseEntity<List<GetAllItemsResponse>> getAllItems() {
        List<GetAllItemsResponse> allItems = this.itemService.getAllItems();

        if (allItems.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allItems, HttpStatus.OK);
    }


    @Operation(description = "Returns the requested item when requested by id.", summary = "Returns item by id.")
    @ApiResponse(responseCode = "200", description = "Returns item.")
    @ApiResponse(responseCode = "404", description = "No item found by the specified id.")
    @GetMapping(path = "/{itemId}")
    public ResponseEntity<GetItemByIdResponse> getItemById(@PathVariable String itemId) {

        GetItemByIdResponse response = this.itemService.getItemById(itemId);

        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CreateNewItemResponse> createNewItem(@RequestBody CreateNewItemRequest request) {
        //TODO returns persisted item or appropriate error
        return new ResponseEntity<>(this.itemService.createNewItem(request), HttpStatus.OK);

    }

    @PatchMapping(path = "/{itemId}")
    public ResponseEntity<ItemDto> editItem(@RequestBody EditItemDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with fields edited or appropriate error
        return new ResponseEntity<>(new ItemDto(
                itemId + "-mock",
                dto.getTitle(),
                dto.getDescription(),
                dto.getVendor(),
                new String[]{"multimedia id1", " multimedia id2"},
                new String[]{"tag id1", " tag id2"}
        ), HttpStatus.OK);
    }

    @PutMapping(path = "/{itemId}")
    public ResponseEntity<String> archiveItem(@RequestParam Boolean isArchived, @PathVariable String itemId) {
        //TODO returns 204 or error

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{itemId}/tags")
    public ResponseEntity<ItemDto> replaceItemTags(@RequestBody ItemTagsDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with the tags replaced or appropriate error
        return new ResponseEntity<>(new ItemDto(itemId + "-mock",
                "title 1",
                "description 1",
                "12345-mock",
                new String[]{"multimedia id1", " multimedia id2"},
                dto.getTagIds()
        ), HttpStatus.OK);
    }

    @PatchMapping(path = "/{itemId}/tags")
    public ResponseEntity<ItemDto> addItemTags(@RequestBody ItemTagsDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with the tags added or appropriate error
        return new ResponseEntity<>(new ItemDto(itemId + "-mock",
                "title 1",
                "description 1",
                "12345-mock",
                new String[]{"multimedia id1, multimedia id2"},
                new String[]{"tag id1", "tag id2", "following tags added: " + Arrays.toString(dto.getTagIds())}
        ), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{itemId}/tags")
    public ResponseEntity<ItemDto> removeItemTags(@RequestBody ItemTagsDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with the tags removed or appropriate error
        return new ResponseEntity<>(new ItemDto(itemId + "-mock",
                "title 1",
                "description 1",
                "12345-mock",
                new String[]{"multimedia id1, multimedia id2"},
                new String[]{"tag id1", "tag id2", "following tags removed: " + Arrays.toString(dto.getTagIds())}
        ), HttpStatus.OK);
    }


    @PutMapping(path = "/{itemId}/multimedia")
    public ResponseEntity<ItemDto> replaceItemMultimedia(@RequestBody ItemMultimediaDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with the multimedia links replaced or appropriate error
        return new ResponseEntity<>(new ItemDto(itemId + "-mock",
                "title 1",
                "description 1",
                "12345-mock",
                dto.getMultimediaIds(),
                new String[]{"tag id1", "tag id2"}
        ), HttpStatus.OK);
    }

    @PatchMapping(path = "/{itemId}/multimedia")
    public ResponseEntity<ItemDto> addItemMultimedia(@RequestBody ItemMultimediaDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with the multimedia links added or appropriate error
        return new ResponseEntity<>(new ItemDto(itemId + "-mock",
                "title 1",
                "description 1",
                "12345-mock",
                new String[]{"multimedia id1", "multimedia id2", "following links added: " + Arrays.toString(dto.getMultimediaIds())},
                new String[]{"tag id1", " tag id2"}
        ), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{itemId}/multimedia")
    public ResponseEntity<ItemDto> removeItemMultimedia(@RequestBody ItemMultimediaDto dto, @PathVariable String itemId) {
        //TODO returns persisted item with the multimedia links removed or appropriate error
        return new ResponseEntity<>(new ItemDto(itemId + "-mock",
                "title 1",
                "description 1",
                "12345-mock",
                new String[]{"multimedia id1", "multimedia id2", "following links removed: " + Arrays.toString(dto.getMultimediaIds())},
                new String[]{"tag id1", "tag id2"}
        ), HttpStatus.OK);
    }


}
