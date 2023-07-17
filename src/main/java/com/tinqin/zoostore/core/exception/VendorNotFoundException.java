package com.tinqin.zoostore.core.exception;

public class VendorNotFoundException extends Exception{
    public VendorNotFoundException(String id) {
        super(String.format("Vendor with id '%s' does not exist.", id));
    }
}
