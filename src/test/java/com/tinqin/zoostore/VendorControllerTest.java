package com.tinqin.zoostore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorRequest;
import com.tinqin.zoostore.api.operations.vendor.createVendor.CreateVendorResponse;
import com.tinqin.zoostore.api.operations.vendor.getVendorById.GetVendorByIdResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc()
@TestPropertySource(value = "/test.yaml")
class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetVendor() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String VENDOR_NAME = "testVendor";
        CreateVendorRequest testVendor = CreateVendorRequest.builder().name(VENDOR_NAME).build();


        MvcResult mvcResult = mockMvc.perform(post("/vendors")
                        .content(mapper.writeValueAsString(testVendor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        String id = mapper.readValue(mvcResult.getResponse().getContentAsString(), CreateVendorResponse.class).getId();

        MvcResult verify = mockMvc.perform(get("/vendors/" + id))
                .andReturn();

        Assertions.assertEquals(id, (mapper.readValue(verify.getResponse().getContentAsString(), GetVendorByIdResponse.class)).getId());
        Assertions.assertEquals(VENDOR_NAME, (mapper.readValue(verify.getResponse().getContentAsString(), GetVendorByIdResponse.class)).getName());

        System.out.println();

    }

}
