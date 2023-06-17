package com.ea544.blogproject.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, Repo extends JpaRepository<T, Integer>> {

    protected final Repo _repo;

    protected BaseService(Repo repo) {
        _repo = repo;
    }

    public void save(T entity) {
        _repo.save(entity);
    }

    public void update(int id, T entity) {
        Optional<T> temp = _repo.findById(id);
        if (temp.isPresent()) {
            _repo.save(entity);
        } else {
            throw new EntityNotFoundException("Entity with id: " + id + " is not found");
        }
    }

    public void delete(Integer id) {
        _repo.deleteById(id);
    }

    public List<T> get() {
        return _repo.findAll();
    }

    public T get(Integer id) {
        Optional<T> temp = _repo.findById(id);
        if (temp.isPresent()) {
            return temp.get();
        } else {
            throw new EntityNotFoundException("Entity with id: " + id + " is not found");
        }
    }

}














