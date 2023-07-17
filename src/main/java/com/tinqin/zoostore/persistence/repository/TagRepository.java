package com.tinqin.zoostore.persistence.repository;

import com.tinqin.zoostore.persistence.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

    Tag findTagByName(String tagName);

    Set<Tag> findAllByIdIn(Set<UUID> uuids);
}
