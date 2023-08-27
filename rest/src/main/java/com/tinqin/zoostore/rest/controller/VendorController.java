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
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vendors")
@RequiredArgsConstructor
@Validated
public class VendorController {

    private final GetVendorByIdOperation getVendorById;
    private final GetAllVendorOperation getAllVendor;
    private final CreateVendorOperation createVendor;
    private final EditVendorOperation editVendor;

    @GetMapping
    public ResponseEntity<GetAllVendorResult> getAllVendors() {
        return ResponseEntity.ok(this.getAllVendor.process(new GetAllVendorInput()));
    }

    @GetMapping(path = "/{vendorId}")
    public ResponseEntity<GetVendorByIdResult> getVendorById(@PathVariable @UUID String vendorId) {
        return ResponseEntity.ok(this.getVendorById.process(new GetVendorByIdInput(java.util.UUID.fromString(vendorId))));
    }

    @PostMapping
    public ResponseEntity<CreateVendorResult> createVendor(@RequestBody CreateVendorInput request) {
        return new ResponseEntity<>(this.createVendor.process(request), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{vendorId}")
    public ResponseEntity<EditVendorResponseResult> editVendor(@PathVariable @UUID String vendorId, @RequestBody EditVendorInput input) {
        input.setId(java.util.UUID.fromString(vendorId));
        return ResponseEntity.ok(this.editVendor.process(input));
    }
}
