package com.tinqin.zoostore.persistence.repository;

import com.tinqin.zoostore.persistence.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    Set<Item> findAllByIsArchivedEquals(Boolean isArchived);
}
