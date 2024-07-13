package com.chpky.fnotes.repository;

import com.chpky.fnotes.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll() throws Exception;
}
