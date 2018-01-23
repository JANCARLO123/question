package com.jcpv.example.questionmarks.service.impl;

import com.jcpv.example.questionmarks.model.Exam;
import com.jcpv.example.questionmarks.repository.ExamRepository;
import com.jcpv.example.questionmarks.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jancarlo on 19/01/18.
 */
@Service
public class ExamServiceImpl  implements ExamService{
    @Autowired
    private ExamRepository examRepository;

    public Exam addExam(Exam exam){
         return examRepository.save(exam);
    }

    public List<Exam> getExams(){
        return examRepository.findAll();
    }

    public boolean addExam2(Exam exam){
        if(examRepository.findByTitle(exam.getTitle())!=null){
            return false;
        }else {
            examRepository.save(exam);
            return true;
        }
    }

}
