package com.tinqin.zoostore.repository;

import com.tinqin.zoostore.data.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

    Tag findTagByName(String tagName);
}
