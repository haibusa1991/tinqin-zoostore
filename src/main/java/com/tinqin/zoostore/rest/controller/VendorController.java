package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResponse;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorResponse;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorResponse;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdRequest;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdOperation;
import com.tinqin.zoostore.core.processor.vendor.EditVendorOperationProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final GetVendorByIdOperation getVendorById;
    private final GetAllVendorOperation getAllVendor;
    private final CreateVendorOperation createVendor;
    private final EditVendorOperation editVendor;

    @GetMapping()
    public ResponseEntity<GetAllVendorResponse> getAllVendors() throws Exception {
        return ResponseEntity.ok(this.getAllVendor.process(new GetAllVendorRequest()));
    }

    @GetMapping(path = "/{vendorId}")
    public ResponseEntity<GetVendorByIdResponse> getVendorById(@PathVariable String vendorId) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {
        return ResponseEntity.ok(this.getVendorById.process(new GetVendorByIdRequest(vendorId)));
    }

    @PostMapping
    public ResponseEntity<CreateVendorResponse> createVendorRequest(@RequestBody CreateVendorRequest request) throws VendorNotFoundException, InvalidUuidException, MultimediaNotFoundException, TagNotFoundException {
        return new ResponseEntity<>(this.createVendor.process(request), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<EditVendorResponse> editVendor(@RequestBody EditVendorRequest request) throws VendorNotFoundException, InvalidUuidException, MultimediaNotFoundException, TagNotFoundException {
        return ResponseEntity.ok(this.editVendor.process(request));
    }
}
