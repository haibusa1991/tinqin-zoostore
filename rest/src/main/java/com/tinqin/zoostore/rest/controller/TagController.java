package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagOperation;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagInput;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagOperation;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagInput;
import com.tinqin.zoostore.api.operations.tag.createTag.CreateTagResult;
import com.tinqin.zoostore.api.operations.tag.editTag.EditTagResult;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagOperation;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagInput;
import com.tinqin.zoostore.api.operations.tag.getAllTag.GetAllTagResult;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdOperation;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdInput;
import com.tinqin.zoostore.api.operations.tag.getTagById.GetTagByIdResult;
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
    public ResponseEntity<GetAllTagResult> getAllTags(GetAllTagInput request) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException {
        return ResponseEntity.ok(this.getAllTag.process(request));
    }

    @GetMapping(path = "/{tagId}")
    public ResponseEntity<GetTagByIdResult> getTagById(@PathVariable String tagId) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException {
        return ResponseEntity.ok(this.getTagById.process(GetTagByIdInput.builder().id(tagId).build()));
    }

    @PostMapping()
    public ResponseEntity<CreateTagResult> createTag(@RequestBody CreateTagInput request) throws MultimediaNotFoundException, VendorNotFoundException, TagNotFoundException {
        return new ResponseEntity<>(this.createTag.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/edit")
    public ResponseEntity<EditTagResult> editTag(@RequestBody EditTagInput request) throws MultimediaNotFoundException, TagNotFoundException, VendorNotFoundException {
        return ResponseEntity.ok(this.editTag.process(request));
    }
}
