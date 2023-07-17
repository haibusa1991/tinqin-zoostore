package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagOperation;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagRequest;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagOperation;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagRequest;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagResponse;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagResponse;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagOperation;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagRequest;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagResponse;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdOperation;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdRequest;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdResponse;
import com.tinqin.zoostore.core.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tags")
@RequiredArgsConstructor
public class TagController {

    private final CreateTagOperation createTag;
    private final EditTagOperation editTag;
    private final GetTagByIdOperation getTagById;
    private final GetAllTagOperation getAllTag;

    @GetMapping()
    public ResponseEntity<GetAllTagResponse> getAllTags(GetAllTagRequest request) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException, InvalidUuidException {
        return ResponseEntity.ok(this.getAllTag.process(request));
    }

    @GetMapping(path = "/{tagId}")
    public ResponseEntity<GetTagByIdResponse> getTagById(@PathVariable String tagId) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException, InvalidUuidException {
        return ResponseEntity.ok(this.getTagById.process(GetTagByIdRequest.builder().id(tagId).build()));
    }

    @PostMapping()
    public ResponseEntity<CreateTagResponse> createTag(@RequestBody CreateTagRequest request) throws MultimediaNotFoundException, VendorNotFoundException, InvalidUuidException, TagNotFoundException {
        return new ResponseEntity<>(this.createTag.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/edit")
    public ResponseEntity<EditTagResponse> editTag(@RequestBody EditTagRequest request) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException, InvalidUuidException {
        return ResponseEntity.ok(this.editTag.process(request));
    }
}
