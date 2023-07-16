package com.tinqin.zoostore.controller;

import com.tinqin.zoostore.data.request.multimedia.CreateMultimediaRequest;
import com.tinqin.zoostore.data.request.multimedia.EditMultimediaRequest;
import com.tinqin.zoostore.data.request.vendor.CreateVendorRequest;
import com.tinqin.zoostore.data.request.vendor.EditVendorRequest;
import com.tinqin.zoostore.data.response.multimedia.CreateMultimediaResponse;
import com.tinqin.zoostore.data.response.multimedia.EditMultimediaResponse;
import com.tinqin.zoostore.data.response.multimedia.GetAllMultimediaResponse;
import com.tinqin.zoostore.data.response.multimedia.GetMultimediaByIdResponse;
import com.tinqin.zoostore.data.response.vendor.CreateVendorResponse;
import com.tinqin.zoostore.data.response.vendor.EditVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetAllVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetVendorByIdResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import com.tinqin.zoostore.service.multimedia.createMultimedia.CreateMultimediaService;
import com.tinqin.zoostore.service.multimedia.editMultimedia.EditMultimediaService;
import com.tinqin.zoostore.service.multimedia.getMultimedia.GetMultimediaService;
import com.tinqin.zoostore.service.vendor.createVendor.CreateVendorService;
import com.tinqin.zoostore.service.vendor.editVendor.EditVendorService;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/multimedia")
@RequiredArgsConstructor
public class MultimediaController {

    private final GetMultimediaService getMultimediaService;
    private final CreateMultimediaService createMultimediaService;
    private final EditMultimediaService editMultimediaService;

    @GetMapping()
    public ResponseEntity<GetAllMultimediaResponse> getAllMultimedia() {
        return ResponseEntity.ok(this.getMultimediaService.getAllMultimedia());
    }

    @GetMapping(path = "/{multimediaId}")
    public ResponseEntity<GetMultimediaByIdResponse> getMultimediaById(@PathVariable String multimediaId) throws IdNotFoundException {
        return ResponseEntity.ok(this.getMultimediaService.getMultimediaById(multimediaId));
    }

    @PostMapping()
    public ResponseEntity<CreateMultimediaResponse> createMultimedia(@RequestBody CreateMultimediaRequest request) {
        return new ResponseEntity<>(this.createMultimediaService.createMultimedia(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{multimediaId}")
    public ResponseEntity<EditMultimediaResponse> editMultimedia(@PathVariable String multimediaId, @RequestBody EditMultimediaRequest request) throws IdNotFoundException {
        return new ResponseEntity<>(this.editMultimediaService.editMultimedia(request, multimediaId), HttpStatus.OK);
    }
}
