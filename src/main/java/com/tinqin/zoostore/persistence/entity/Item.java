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
public class Item {

    @Builder
    public Item(String title, String description, Vendor vendor, Set<Tag> tags, List<Multimedia> multimediaLinks) {
        this.title = title;
        this.description = description;
        this.vendor = vendor;
        this.tags = tags;
        this.multimediaLinks = multimediaLinks;
        this.isArchived = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Vendor vendor;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<Multimedia> multimediaLinks;

    private Boolean isArchived;


}
