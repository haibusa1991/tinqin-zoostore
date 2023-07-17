package com.tinqin.zoostore.api.base;

import com.tinqin.zoostore.core.exception.*;

public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {

    R process(I request) throws InvalidUuidException, VendorNotFoundException, MultimediaNotFoundException, TagNotFoundException;
}
