package com.sandeepkamathkr.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private long Id;

    @Column(name = "POST_ID",columnDefinition = "VARCHAR(50)", nullable = false)
    private long postId;

    @Column(name = "NAME",columnDefinition = "VARCHAR(2000)", nullable = false )
    private String name;

    @Column(name = "EMAIL",columnDefinition = "VARCHAR(50)", nullable = false )
    private String email;

    @Column(name = "BODY",columnDefinition = "VARCHAR(4000)", nullable = false )
    private String body;
}
