package com.tinqin.zoostore.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "items")
@Setter
@Getter
@NoArgsConstructor
public class Item extends BaseEntity {

    @Builder
    public Item(String title, String description, Vendor vendor, Set<Tag> tags, Set<Multimedia> multimedia) {
        this.title = title;
        this.description = description;
        this.vendor = vendor;
        this.tags = tags;
        this.multimedia = multimedia;
        this.isArchived = false;
    }

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Vendor vendor;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private Set<Multimedia> multimedia;

    private Boolean isArchived;


}
