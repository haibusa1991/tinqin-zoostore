package com.tinqin.zoostore.persistence.entity;

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
public class Vendor extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER)
    private Set<Item> items;
}
