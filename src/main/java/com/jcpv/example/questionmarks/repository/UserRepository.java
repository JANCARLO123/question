package com.jcpv.example.questionmarks.repository;

import com.jcpv.example.questionmarks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jancarlo on 23/03/18.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long>{


    public List<User> findByName(String name);
    @Query("select u from User u where u.name like %?1")
    public List<User> findByNameEndsWith(String name);

}
