package com.skinDreams.School.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Builder
@Validated
@Entity
public class Client implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    @Valid
    private String name;


    @NotEmpty(message = "Phone should not be empty")
    @Column(name = "phone")
    private String phone;








}
