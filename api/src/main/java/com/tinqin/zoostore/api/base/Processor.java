package com.tinqin.zoostore.api.base;

public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {

    R process(I request);
}
