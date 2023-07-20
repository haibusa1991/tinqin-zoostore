package com.tinqin.zoostore.rest.controller;

import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorInput;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResult;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorInput;
import com.tinqin.zoostore.api.operations.vendor.editVendor.EditVendorResponseResult;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorOperation;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorInput;
import com.tinqin.zoostore.api.operations.vendor.getAllVendor.GetAllVendorResult;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdInput;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResult;
import com.tinqin.zoostore.core.exception.MultimediaNotFoundException;
import com.tinqin.zoostore.core.exception.TagNotFoundException;
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
    private final EditVendorOperation editVendor;

    @GetMapping()
    public ResponseEntity<GetAllVendorResult> getAllVendors() throws Exception {
        return ResponseEntity.ok(this.getAllVendor.process(new GetAllVendorInput()));
    }

    @GetMapping(path = "/{vendorId}")
    public ResponseEntity<GetVendorByIdResult> getVendorById(@PathVariable String vendorId) throws VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {
        return ResponseEntity.ok(this.getVendorById.process(new GetVendorByIdInput(vendorId)));
    }

    @PostMapping
    public ResponseEntity<CreateVendorResult> createVendorRequest(@RequestBody CreateVendorInput request) throws VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {
        return new ResponseEntity<>(this.createVendor.process(request), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<EditVendorResponseResult> editVendor(@RequestBody EditVendorInput request) throws VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException {
        return ResponseEntity.ok(this.editVendor.process(request));
    }
}
