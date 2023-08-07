package com.tinqin.zoostore.persistence.repository;

import com.tinqin.zoostore.persistence.entity.Item;
import com.tinqin.zoostore.persistence.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    Page<Item> findAllByIsArchivedEquals(Boolean isArchived, Pageable pageable);

    Set<Item> findAllByTagsContaining(Tag tag);

    Page<Item> findAllByIsArchivedEqualsAndTagsContaining(Boolean isArchived, Tag tag, Pageable pageable);

    Page<Item> findAllByTagsContaining(Tag tag, Pageable pageable);

    @Query(value = """
            SELECT *
            FROM items i
            WHERE i.title REGEXP :regex
            ORDER BY title ASC
            """, nativeQuery = true)
    Page<Item> findAllByPartialTitle(String regex, Pageable pageable);
}
