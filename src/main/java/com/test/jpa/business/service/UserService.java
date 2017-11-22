package com.test.jpa.business.service;

import com.test.jpa.bean.User;
import com.test.jpa.business.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengrongze on 2017/11/21.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User queryUserByName(String userName){
        return userRepository.findByName(userName);
    }

    public Iterable<User> queryAllUser() {
        return userRepository.findAll();
    }

    public User queryUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Transactional
    public void save(User su) {
        userRepository.save(su);
        this.update();
    }


    public void update(){
        userRepository.updateEmail("fengrongze@163.com","frz");
      /*  if(true){
            throw new RuntimeException("什么情况呢呢呢？");
        }*/
    }
}
