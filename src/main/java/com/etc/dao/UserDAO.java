package com.etc.dao;

import com.etc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
   // void save(@Param("user") String name);
    void save(User user);
    void update(User user);
    void delect(User user);
    User queryById(User user);
    List<User> queryByLike(@Param("name") String name);
}
