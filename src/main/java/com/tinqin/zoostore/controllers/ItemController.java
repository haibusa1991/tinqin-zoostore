package com.tinqin.zoostore.controllers;

import com.tinqin.zoostore.dto.CreateItemDto;
import com.tinqin.zoostore.dto.ExistingTagDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @PostMapping(path = "/create")
    public ResponseEntity<String> createNewItem(@RequestBody CreateItemDto dto) {

        //TODO Add service
        return ResponseEntity.ok("TODO Here goes new item UUID");
    }

    @PostMapping(path = "/addTag")
    public ResponseEntity<String> addItemTag(@RequestBody ExistingTagDto dto) {

        //TODO Add service
        return ResponseEntity.ok("TODO Tag with ID 12345 added successfully.");
    }

    @PostMapping(path = "/removeTag")
    public ResponseEntity<String> removeItemTag(@RequestBody ExistingTagDto dto) {

        //TODO Add service
        return ResponseEntity.ok("TODO Tag with ID 12345 removed successfully.");
    }

    @PostMapping(path = "/replaceTags")
    public ResponseEntity<String> replaceItemTags(@RequestBody ExistingTagDto dto) {

        //TODO Add service
        return ResponseEntity.ok("TODO Tag with ID 12345 added successfully.");
    }



}
