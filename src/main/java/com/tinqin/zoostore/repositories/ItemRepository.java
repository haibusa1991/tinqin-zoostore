package com.tinqin.zoostore.repositories;

import com.tinqin.zoostore.models.Item;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Override
    @NotNull
    @Query("""
            SELECT i
            FROM Item i
            LEFT JOIN FETCH i.multimediaLinks mml
            LEFT JOIN FETCH i.tags t
             """)
    List<Item> findAll();


    @Query("""
            SELECT i
            FROM Item i
            LEFT JOIN FETCH i.multimediaLinks mml
            LEFT JOIN FETCH i.tags t
            WHERE i.id=:id
             """)
    Item getItemById(UUID id);
}
