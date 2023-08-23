package com.tinqin.zoostore.rest.controller;

import com.tinqin.restexport.annotation.RestExport;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaInput;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaResult;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResult;
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
@RequestMapping(path = "/multimedia")
@RequiredArgsConstructor
@Validated
public class MultimediaController {
    private final CreateMultimediaOperation createMultimedia;
    private final EditMultimediaOperation editMultimedia;
    private final GetAllMultimediaOperation getAllMultimedia;
    private final GetMultimediaByIdOperation getMultimediaById;

    @Operation(description = "Returns all multimedia.", summary = "Returns all multimedia.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all items or empty array.")})
    @RestExport
    @GetMapping()
    public ResponseEntity<GetAllMultimediaResult> getAllMultimedia() {
        return ResponseEntity.ok(this.getAllMultimedia.process(new GetAllMultimediaInput()));
    }

    @Operation(description = "Returns multimedia by specified id.", summary = "Returns multimedia by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns specified multimedia."),
            @ApiResponse(responseCode = "400", description = "Multimedia id not valid.", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Multimedia with the specified id not found.", content = @Content())})
    @RestExport
    @GetMapping(path = "/{multimediaId}")
    public ResponseEntity<GetMultimediaByIdResult> getMultimediaById(@PathVariable @UUID String multimediaId) {
        return ResponseEntity.ok(this.getMultimediaById.process(GetMultimediaByIdInput.builder().id(java.util.UUID.fromString(multimediaId)).build()));
    }

    @Operation(description = "Creates multimedia by name and returns multimedia.", summary = "Creates multimedia.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creates and returns multimedia.")})
    @RestExport
    @PostMapping()
    public ResponseEntity<CreateMultimediaResult> createMultimedia(@RequestBody CreateMultimediaInput request) {
        return new ResponseEntity<>(this.createMultimedia.process(request), HttpStatus.CREATED);
    }

    @Operation(description = "Edits multimedia by specified id and returns edited multimedia.", summary = "Edits and returns multimedia by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns edited multimedia."),
            @ApiResponse(responseCode = "400", description = "Multimedia id not valid.", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Multimedia with the specified id not found.", content = @Content())})
    @RestExport
    @PatchMapping(path = "/edit")
    public ResponseEntity<EditMultimediaResult> editMultimedia(@RequestBody EditMultimediaInput request) {
        return new ResponseEntity<>(this.editMultimedia.process(request), HttpStatus.OK);
    }
}
