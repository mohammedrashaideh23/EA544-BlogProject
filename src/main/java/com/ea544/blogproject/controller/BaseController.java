package com.ea544.blogproject.controller;

import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<T> {
    T get(int id);

    T get();

    void put(RequestBody T);

    void delete(int id);

    void save(@RequestBody T entity);

}
