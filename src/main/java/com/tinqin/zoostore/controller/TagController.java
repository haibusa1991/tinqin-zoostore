package com.tinqin.zoostore.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
public class TagController {
//
//    @GetMapping()
//    public ResponseEntity<List<TagDto>> getAllTags() {
//        //TODO returns all tags or 404
//
//        return ResponseEntity.ok(List.of(
//                new TagDto("12345-mock", "tag 1"),
//                new TagDto("67891-mock", "tag 2")
//        ));
//    }
//
//    @GetMapping(path = "/{tagId}")
//    public ResponseEntity<TagDto> getTagById(@PathVariable String tagId) {
//        //TODO returns tag by id or 404
//
//        return ResponseEntity.ok(new TagDto(tagId + "-mock", "tag 1"));
//    }
//
//    @PostMapping()
//    public ResponseEntity<TagDto> createNewTag(@RequestBody CreateTagDto dto) {
//        //TODO returns persisted tag
//
//        return new ResponseEntity<>(new TagDto("123456-mock", dto.getValue()), HttpStatus.CREATED);
//    }
//
//    @PatchMapping(path = "/{tagId}")
//    public ResponseEntity<TagDto> editTag(@PathVariable String tagId, @RequestBody EditTagValueDto dto) {
//        //TODO returns persisted tag or appropriate error
//
//        return new ResponseEntity<>(new TagDto(tagId, dto.getValue()), HttpStatus.OK);
//    }
//
//    @DeleteMapping(path = "/{tagId}")
//    public ResponseEntity<String> deleteTag(@PathVariable String tagId) {
//        //TODO returns 204 or appropriate error. Should not delete tag in use
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
