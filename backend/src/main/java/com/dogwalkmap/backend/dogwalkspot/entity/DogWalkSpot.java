package com.dogwalkmap.backend.dogwalkspot.entity;

import com.dogwalkmap.backend.common.enums.ContactPreference;
import com.dogwalkmap.backend.dog.entity.Dog;
import com.dogwalkmap.backend.location.entity.WalkLocation;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "dog_walk_spots")
public class DogWalkSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dog_id", nullable = false)
    private Dog dog;

    @ManyToOne
    @JoinColumn(name = "walk_location_id", nullable = false)
    private WalkLocation walkLocation;

    @Column(nullable = false)
    private LocalTime timeFrom;

    @Column(nullable = false)
    private LocalTime timeTo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContactPreference contactPreference;

    @Column(nullable = false)
    private boolean active;

    private String comment;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
