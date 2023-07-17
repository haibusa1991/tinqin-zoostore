//package com.tinqin.zoostore.rest.controller;
//
//import com.tinqin.zoostore.api.request.multimedia.CreateMultimediaRequest;
//import com.tinqin.zoostore.api.request.multimedia.EditMultimediaRequest;
//import com.tinqin.zoostore.api.response.multimedia.CreateMultimediaResponse;
//import com.tinqin.zoostore.api.response.multimedia.EditMultimediaResponse;
//import com.tinqin.zoostore.api.response.multimedia.GetAllMultimediaResponse;
//import com.tinqin.zoostore.api.response.multimedia.GetMultimediaByIdResponse;
//import com.tinqin.zoostore.core.exception.IdNotFoundException;
//import com.tinqin.zoostore.core.service.multimedia.createMultimedia.CreateMultimediaService;
//import com.tinqin.zoostore.core.service.multimedia.editMultimedia.EditMultimediaService;
//import com.tinqin.zoostore.core.service.multimedia.getMultimedia.GetMultimediaService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/multimedia")
//@RequiredArgsConstructor
//public class MultimediaController {
//
//    private final GetMultimediaService getMultimediaService;
//    private final CreateMultimediaService createMultimediaService;
//    private final EditMultimediaService editMultimediaService;
//
//    @GetMapping()
//    public ResponseEntity<GetAllMultimediaResponse> getAllMultimedia() {
//        return ResponseEntity.ok(this.getMultimediaService.getAllMultimedia());
//    }
//
//    @GetMapping(path = "/{multimediaId}")
//    public ResponseEntity<GetMultimediaByIdResponse> getMultimediaById(@PathVariable String multimediaId) throws IdNotFoundException {
//        return ResponseEntity.ok(this.getMultimediaService.getMultimediaById(multimediaId));
//    }
//
//    @PostMapping()
//    public ResponseEntity<CreateMultimediaResponse> createMultimedia(@RequestBody CreateMultimediaRequest request) {
//        return new ResponseEntity<>(this.createMultimediaService.createMultimedia(request), HttpStatus.CREATED);
//    }
//
//    @PatchMapping(path = "/{multimediaId}")
//    public ResponseEntity<EditMultimediaResponse> editMultimedia(@PathVariable String multimediaId, @RequestBody EditMultimediaRequest request) throws IdNotFoundException {
//        return new ResponseEntity<>(this.editMultimediaService.editMultimedia(request, multimediaId), HttpStatus.OK);
//    }
//}
