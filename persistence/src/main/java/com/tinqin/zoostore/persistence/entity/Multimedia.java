package com.tinqin.zoostore.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "multimedia")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Multimedia extends BaseEntity{

    @Column(nullable = false)
    private String url;

    @ManyToOne
    private Item item;
}
