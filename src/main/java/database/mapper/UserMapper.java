package database.mapper;

import database.model.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
