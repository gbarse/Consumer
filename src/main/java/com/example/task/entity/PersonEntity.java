package com.example.task.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_person")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime dateUpdated;

    @Column(name = "delete_date")
    private LocalDateTime dateDeleted;
}
