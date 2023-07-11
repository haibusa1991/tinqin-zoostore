package com.tinqin.zoostore.repository;

import com.tinqin.zoostore.data.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {

    Vendor findByName(String vendorName);

}
