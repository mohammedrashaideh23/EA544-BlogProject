package com.ea544.blogproject.shared;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseController<T> {
    T get(Integer id);

    List<T> get();

    void update(@RequestBody  T entity ,Integer id);

    void delete(Integer id);

    void save(@RequestBody T entity);

}
