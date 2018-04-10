package com.jcpv.example.questionmarks.controller;

import com.jcpv.example.questionmarks.model.Exam;
import com.jcpv.example.questionmarks.service.ExamService;
import com.jcpv.example.questionmarks.service.impl.ExamServiceImpl;
import com.jcpv.example.questionmarks.service.jms.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jancarlo on 19/01/18.
 */
@Controller
@RequestMapping("exam")
public class ExamContoller {
    @Autowired
    private ExamService examService;
    @Autowired
    private JmsSender jmsSender;

    @GetMapping("exams")
    public ResponseEntity<List<Exam>> getAllArticles() throws InterruptedException {
       List<Exam> examns = examService.getExams();
        for(Exam exam : examns){
            jmsSender.send(exam);
            jmsSender.send("name-queue2",exam);
            TimeUnit.SECONDS.sleep(3);
        }
        return new ResponseEntity<List<Exam>>(examService.getExams(), HttpStatus.OK);
    }
}
