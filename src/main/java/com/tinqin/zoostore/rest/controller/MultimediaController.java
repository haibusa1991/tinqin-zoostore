package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResponse;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaRequest;
import com.tinqin.zoostore.api.operations.multimedia.editMultimedia.EditMultimediaResponse;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaOperation;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaRequest;
import com.tinqin.zoostore.api.operations.multimedia.getAllMultimedia.GetAllMultimediaResponse;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdRequest;
import com.tinqin.zoostore.api.operations.multimedia.getMultimediaById.GetMultimediaByIdResponse;
import com.tinqin.zoostore.core.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/multimedia")
@RequiredArgsConstructor
public class MultimediaController {
    private final CreateMultimediaOperation createMultimedia;
    private final EditMultimediaOperation editMultimedia;
    private final GetAllMultimediaOperation getAllMultimedia;
    private final GetMultimediaByIdOperation getMultimediaById;


    @GetMapping()
    public ResponseEntity<GetAllMultimediaResponse> getAllMultimedia(GetAllMultimediaRequest request) throws VendorNotFoundException, InvalidUuidException, MultimediaNotFoundException, TagNotFoundException {
        return ResponseEntity.ok(this.getAllMultimedia.process(request));
    }

    @GetMapping(path = "/{multimediaId}")
    public ResponseEntity<GetMultimediaByIdResponse> getMultimediaById(@PathVariable String multimediaId) throws MultimediaNotFoundException, VendorNotFoundException, InvalidUuidException, TagNotFoundException {
        return ResponseEntity.ok(this.getMultimediaById.process(GetMultimediaByIdRequest.builder().id(multimediaId).build()));
    }

    @PostMapping()
    public ResponseEntity<CreateMultimediaResponse> createMultimedia(@RequestBody CreateMultimediaRequest request) throws VendorNotFoundException, InvalidUuidException, MultimediaNotFoundException, TagNotFoundException {
        return new ResponseEntity<>(this.createMultimedia.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/edit")
    public ResponseEntity<EditMultimediaResponse> editMultimedia(@RequestBody EditMultimediaRequest request) throws VendorNotFoundException, InvalidUuidException, MultimediaNotFoundException, TagNotFoundException {
        return new ResponseEntity<>(this.editMultimedia.process(request), HttpStatus.OK);
    }
}
