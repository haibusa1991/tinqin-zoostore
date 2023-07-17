package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResponse;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorResponse;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdRequest;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResponse;
import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdOperation;
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

    @GetMapping()
    public ResponseEntity<GetAllVendorResponse> getAllVendors() throws Exception {
        return ResponseEntity.ok(this.getAllVendor.process(new GetAllVendorRequest()));
    }

    @GetMapping(path = "/{vendorId}")
    public ResponseEntity<GetVendorByIdResponse> getVendorById(@PathVariable String vendorId) throws InvalidUuidException, VendorNotFoundException {
        return ResponseEntity.ok(this.getVendorById.process(new GetVendorByIdRequest(vendorId)));
    }

    @PostMapping
    public ResponseEntity<CreateVendorResponse> createVendorRequest(@RequestBody CreateVendorRequest request) throws VendorNotFoundException, InvalidUuidException {
        return new ResponseEntity<>(this.createVendor.process(request), HttpStatus.CREATED);
    }
//
//    @PatchMapping(path = "/{vendorId}")
//    public ResponseEntity<EditVendorResponse> editVendor(@PathVariable String vendorId, @RequestBody EditVendorRequest request) throws VendorNotFoundException, IdNotFoundException {
//        return new ResponseEntity<>(this.editVendorService.editVendor(request,vendorId), HttpStatus.OK);
//    }
}
