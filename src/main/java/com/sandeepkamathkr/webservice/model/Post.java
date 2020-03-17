package com.sandeepkamathkr.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private long Id;

    @Column(name = "USER_ID", nullable = false)
    private long userId;

    @Column(name = "TITLE",columnDefinition = "VARCHAR(4000)", nullable = false )
    private String title;

    @Column(name = "BODY",columnDefinition = "VARCHAR(4000)", nullable = false )
    private String body;
}
