package com.tinqin.zoostore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vendors")
public class VendorController {
//
//    @GetMapping()
//    public ResponseEntity<List<VendorDto>> getAllVendors() {
//        //TODO returns all vendors or 404
//
//        return ResponseEntity.ok(List.of(
//                new VendorDto("12345-mock", "vendor 1"),
//                new VendorDto("67891-mock", "vendor 2")
//        ));
//    }
//
//    @GetMapping(path = "/{vendorId}")
//    public ResponseEntity<VendorDto> getVendorById(@PathVariable String vendorId) {
//        //TODO returns vendor by id or 404
//
//        return ResponseEntity.ok(new VendorDto(vendorId + "-mock", "vendor 1"));
//    }
//
//    @PostMapping()
//    public ResponseEntity<VendorDto> createNewVendor(@RequestBody CreateVendorDto dto) {
//        //TODO returns persisted vendor
//
//        return new ResponseEntity<>(new VendorDto("123456-mock", dto.getName()), HttpStatus.CREATED);
//    }
//
//    @PatchMapping(path = "/{vendorId}")
//    public ResponseEntity<VendorDto> editVendor(@PathVariable String vendorId, @RequestBody EditVendorNameDto dto) {
//        //TODO returns persisted vendor or appropriate error
//
//        return new ResponseEntity<>(new VendorDto(vendorId, dto.getName()), HttpStatus.OK);
//    }
//
//    @DeleteMapping(path = "/{vendorId}")
//    public ResponseEntity<String> deleteVendor(@PathVariable String vendorId) {
//        //TODO returns 204 or appropriate error. Should not delete vendor in use
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
