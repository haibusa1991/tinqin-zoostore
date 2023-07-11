package com.tinqin.zoostore.data.response.vendor;

import com.tinqin.zoostore.data.response.item.GetItemByIdResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class GetAllVendorResponse {
    List<GetVendorByIdResponse> vendors;
}
