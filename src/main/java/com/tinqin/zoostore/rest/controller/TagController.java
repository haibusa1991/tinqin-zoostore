//package com.tinqin.zoostore.rest.controller;
//
//import com.tinqin.zoostore.api.request.tag.CreateTagRequest;
//import com.tinqin.zoostore.api.request.tag.EditTagRequest;
//import com.tinqin.zoostore.api.response.tag.CreateTagResponse;
//import com.tinqin.zoostore.api.response.tag.EditTagResponse;
//import com.tinqin.zoostore.api.response.tag.GetAllTagResponse;
//import com.tinqin.zoostore.api.response.tag.GetTagByIdResponse;
//import com.tinqin.zoostore.core.exception.IdNotFoundException;
//import com.tinqin.zoostore.core.service.tag.createTag.CreateTagService;
//import com.tinqin.zoostore.core.service.tag.editTag.EditTagService;
//import com.tinqin.zoostore.core.service.tag.getTag.GetTagService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/tags")
//@RequiredArgsConstructor
//public class TagController {
//
//    private final GetTagService getTagService;
//    private final CreateTagService createTagService;
//    private final EditTagService editTagService;
//
//    @GetMapping()
//    public ResponseEntity<GetAllTagResponse> getAllTags() {
//        return ResponseEntity.ok(this.getTagService.getAll());
//    }
//
//    @GetMapping(path = "/{tagId}")
//    public ResponseEntity<GetTagByIdResponse> getTagById(@PathVariable String tagId) {
//        return ResponseEntity.ok(this.getTagService.getTagById(tagId));
//    }
//
//    @PostMapping()
//    public ResponseEntity<CreateTagResponse> createNewTag(@RequestBody CreateTagRequest request) {
//        return new ResponseEntity<>(this.createTagService.createTag(request), HttpStatus.CREATED);
//    }
//
//    @PatchMapping(path = "/{tagId}")
//    public ResponseEntity<EditTagResponse> editTag(@PathVariable String tagId, @RequestBody EditTagRequest request) throws IdNotFoundException {
//        return ResponseEntity.ok(this.editTagService.editTag(request,tagId));
//    }
//}
