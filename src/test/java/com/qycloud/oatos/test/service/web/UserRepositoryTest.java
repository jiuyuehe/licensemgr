package com.qycloud.oatos.test.service.web;

import com.qycloud.oatos.license.ApplicationApp;
import com.qycloud.oatos.license.domain.User;
import com.qycloud.oatos.license.service.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by jiuyuehe on 2015/1/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationApp.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAllUsers(){
        List<User> users = this.userRepository.findAll();
        System.out.println(users.size());
        assertThat(users.size(),is(greaterThan(2)));
    }

    @Test
    public void addUser(){
        User u = new User();
        u.setName("weinan");
        u.setEmail("weinan@126.com");
        u.setPassword("123456");
        u.setRole("4");
        User us = this.userRepository.save(u);
        assertTrue(us.getName().equals(u.getName()));
    }

    @Test
    public void getEmail(){
        User u = this.userRepository.findByEmail("ldl@qycloud.com");
        assertTrue(u.getName().equals("老大难"));
        User u1 =  this.userRepository.findByEmailAndPassword("ldl@qycloud.com","123456");
        assertTrue(u1.getName().equals("老大难"));
    }

}
