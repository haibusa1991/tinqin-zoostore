package com.tinqin.zoostore.rest.controller;

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
    public ResponseEntity<GetAllMultimediaResult> getAllMultimedia(GetAllMultimediaInput request) {
        return ResponseEntity.ok(this.getAllMultimedia.process(request));
    }

    @GetMapping(path = "/{multimediaId}")
    public ResponseEntity<GetMultimediaByIdResult> getMultimediaById(@PathVariable String multimediaId) {
        return ResponseEntity.ok(this.getMultimediaById.process(GetMultimediaByIdInput.builder().id(multimediaId).build()));
    }

    @PostMapping()
    public ResponseEntity<CreateMultimediaResult> createMultimedia(@RequestBody CreateMultimediaInput request) {
        return new ResponseEntity<>(this.createMultimedia.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/edit")
    public ResponseEntity<EditMultimediaResult> editMultimedia(@RequestBody EditMultimediaInput request) {
        return new ResponseEntity<>(this.editMultimedia.process(request), HttpStatus.OK);
    }
}
