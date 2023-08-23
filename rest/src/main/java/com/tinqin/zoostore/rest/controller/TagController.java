package com.tinqin.zoostore.rest.controller;

import com.tinqin.restexport.annotation.RestExport;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tags")
@RequiredArgsConstructor
@Validated
public class TagController {

    private final CreateTagOperation createTag;
    private final EditTagOperation editTag;
    private final GetTagByIdOperation getTagById;
    private final GetAllTagOperation getAllTag;

    @Operation(description = "Returns all tags.", summary = "Returns all tags.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all tags or empty array.")})
    @RestExport
    @GetMapping()
    public ResponseEntity<GetAllTagResult> getAllTags(GetAllTagInput input) {
        return ResponseEntity.ok(this.getAllTag.process(input));
    }
    @Operation(description = "Returns tag by specified id.", summary = "Returns tag by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns specified tag."),
            @ApiResponse(responseCode = "400", description = "Tag id not valid.", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Tag with the specified id not found.", content = @Content())})
    @RestExport
    @GetMapping(path = "/{tagId}")
    public ResponseEntity<GetTagByIdResult> getTagById(@PathVariable @UUID String tagId) {
        return ResponseEntity.ok(this.getTagById.process(GetTagByIdInput.builder().id(java.util.UUID.fromString(tagId)).build()));
    }

    @PostMapping()
    public ResponseEntity<CreateTagResult> createTag(@RequestBody CreateTagInput request) {
        return new ResponseEntity<>(this.createTag.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{tagId}")
    public ResponseEntity<EditTagResult> editTag(@PathVariable @UUID String tagId, @RequestBody EditTagInput input) {
        input.setId(java.util.UUID.fromString(tagId));
        return ResponseEntity.ok(this.editTag.process(input));
    }
}
