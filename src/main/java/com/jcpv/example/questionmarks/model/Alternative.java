package com.jcpv.example.questionmarks.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
/**
 * Created by jancarlo on 6/12/17.
 */
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private long order;

    @NotNull
    private String description;

    private boolean correct;
}
