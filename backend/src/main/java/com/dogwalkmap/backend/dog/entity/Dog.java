package com.dogwalkmap.backend.dog.entity;

import com.dogwalkmap.backend.common.enums.DogSex;
import com.dogwalkmap.backend.dogwalkspot.entity.DogWalkSpot;
import com.dogwalkmap.backend.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String breed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DogSex sex;

    private LocalDate birthDate;

    private String behaviorDescription;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "dog")
    private List<DogWalkSpot> dogWalkSpots = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
