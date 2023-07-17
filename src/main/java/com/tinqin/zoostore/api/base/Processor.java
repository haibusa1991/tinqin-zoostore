package com.tinqin.zoostore.api.base;

import com.tinqin.zoostore.core.exception.InvalidUuidException;
import com.tinqin.zoostore.core.exception.VendorNotFoundException;

public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {

    R process(I request) throws InvalidUuidException, VendorNotFoundException;
}
