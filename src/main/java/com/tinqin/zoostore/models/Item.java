package com.tinqin.zoostore.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "items")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true,nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Vendor vendor;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(mappedBy = "item")
    private Set<Multimedia> multimediaLinks;


}
