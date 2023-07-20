package com.tinqin.zoostore.persistence.repository;

import com.tinqin.zoostore.persistence.entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, UUID> {

    Set<Multimedia> findAllByIdIn(Set<UUID> uuids);

}
