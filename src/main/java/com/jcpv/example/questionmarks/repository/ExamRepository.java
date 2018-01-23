package com.jcpv.example.questionmarks.repository;

import com.jcpv.example.questionmarks.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jancarlo on 19/01/18.
 */
@Repository
@Transactional
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam findByTitle(String title);

    @Query("select u from Exam u where u.title like %?1")
    List<Exam> findByTitleEndsWith(String title);

    @Query(value = "SELECT * FROM Exam WHERE NAME = ?1",
            nativeQuery = true)
    Exam findByTitleQuery(String title);
}
