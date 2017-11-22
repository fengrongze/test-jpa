package com.test.jpa.business.dao;


import com.test.jpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengrongze on 2017/11/21.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(@Param("name") String userName);

    @Query("from User u where u.name=:name")
    User findUserByUserName(@Param("name") String userName);


    @Modifying
    @Query("update User set email=?1 where name=?2")
    void updateEmail(String email,String userName);
}
