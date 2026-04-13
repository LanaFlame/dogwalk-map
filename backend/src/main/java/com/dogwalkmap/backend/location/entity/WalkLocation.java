package com.dogwalkmap.backend.location.entity;

import com.dogwalkmap.backend.common.enums.WalkLocationType;
import com.dogwalkmap.backend.dogwalkspot.entity.DogWalkSpot;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "walk_location")
public class WalkLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WalkLocationType type;

    private String description;

    @OneToMany(mappedBy = "walkLocation")
    List<DogWalkSpot> dogWalkSpots = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
