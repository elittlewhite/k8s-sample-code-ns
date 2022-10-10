package com.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.demo.mapper.UserMapper;
import com.demo.model.User;

@Service
public class UserService {
  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserMapper userMapper;

  public User getUser(Long id) {
    logger.info("recrived id from api rest: {}", id);
    
    User user = userMapper.get(id);
    
    logger.info("return user to api rest: {}", user);
    return user;
  }

  public void save(User user) {
    userMapper.insert(user);
  }

  public void update(User user) {
    userMapper.update(user);
  }

  public void delete(@PathVariable("id") Long id) {
    userMapper.delete(id);
  }
}
