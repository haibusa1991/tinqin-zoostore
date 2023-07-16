package com.tinqin.zoostore.controller;

import com.tinqin.zoostore.data.request.vendor.CreateVendorRequest;
import com.tinqin.zoostore.data.request.vendor.EditVendorRequest;
import com.tinqin.zoostore.data.response.vendor.CreateVendorResponse;
import com.tinqin.zoostore.data.response.vendor.EditVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetAllVendorResponse;
import com.tinqin.zoostore.data.response.vendor.GetVendorByIdResponse;
import com.tinqin.zoostore.exception.IdNotFoundException;
import com.tinqin.zoostore.exception.VendorNotFoundException;
import com.tinqin.zoostore.service.vendor.createVendor.CreateVendorService;
import com.tinqin.zoostore.service.vendor.editVendor.EditVendorService;
import com.tinqin.zoostore.service.vendor.getVendor.GetVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final GetVendorService getVendorService;
    private final CreateVendorService createVendorService;
    private final EditVendorService editVendorService;

    @GetMapping()
    public ResponseEntity<GetAllVendorResponse> getAllVendors() {
        return ResponseEntity.ok(this.getVendorService.getAllVendor());
    }

    @GetMapping(path = "/{vendorId}")
    public ResponseEntity<GetVendorByIdResponse> getVendorById(@PathVariable String vendorId) throws IdNotFoundException {
        return ResponseEntity.ok(this.getVendorService.getVendorById(vendorId));
    }

    @PostMapping()
    public ResponseEntity<CreateVendorResponse> createNewVendor(@RequestBody CreateVendorRequest request) {
        return new ResponseEntity<>(this.createVendorService.createVendor(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{vendorId}")
    public ResponseEntity<EditVendorResponse> editVendor(@PathVariable String vendorId, @RequestBody EditVendorRequest request) throws VendorNotFoundException, IdNotFoundException {
        return new ResponseEntity<>(this.editVendorService.editVendor(request,vendorId), HttpStatus.OK);
    }
}
