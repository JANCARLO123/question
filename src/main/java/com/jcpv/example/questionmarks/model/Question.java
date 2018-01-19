package com.jcpv.example.questionmarks.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * Created by jancarlo on 6/12/17.
 */
@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private long order;

    @NotNull
    private String description;

}
