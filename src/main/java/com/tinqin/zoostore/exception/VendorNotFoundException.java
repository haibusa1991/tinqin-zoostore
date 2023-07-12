package com.tinqin.zoostore.exception;

public class VendorNotFoundException extends Exception{
    public VendorNotFoundException() {
        super("Vendor id does not exist.");
    }
}
