package com.demo.mapper;

import java.util.List;
import com.demo.model.User;

public interface UserMapper {

  List<User> getAll();

  User get(Long id);

  void insert(User user);

  void update(User user);

  void delete(Long id);

}
