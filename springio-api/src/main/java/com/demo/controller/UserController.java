package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping(value = "/db/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  @GetMapping(value = "/{id}")
  public User getUser(@PathVariable(name = "id", required = true) Long id) {
    return userService.getUser(id);
  }

  @PostMapping
  public void save(@RequestBody User user) {
    userService.save(user);
  }

  @PutMapping
  public void update(@RequestBody User user) {
    userService.update(user);
  }

  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Long id) {
    userService.delete(id);
  }
}
