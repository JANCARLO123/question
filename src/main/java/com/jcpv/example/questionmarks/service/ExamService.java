package com.jcpv.example.questionmarks.service;

import com.jcpv.example.questionmarks.model.Exam;

import java.util.List;

/**
 * Created by jancarlo on 19/01/18.
 */
public interface ExamService{
    public Exam addExam(Exam exam);
    public boolean addExam2(Exam exam);
    public List<Exam> getExams();
}
