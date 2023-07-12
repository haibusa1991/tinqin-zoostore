package com.tinqin.zoostore.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "vendors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "vendorId", fetch = FetchType.EAGER)
    private Set<Item> items;
}
