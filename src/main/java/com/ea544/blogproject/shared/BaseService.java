package com.ea544.blogproject.shared;

import com.ea544.blogproject.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, Repo extends JpaRepository<T, Integer>> {

    protected final Repo _repo;

    protected BaseService(Repo repo, Class<T> type) {
        _repo = repo;
    }

    public void save(T entity) {
        _repo.save(entity);
    }

    public void update(int id, T entity) {
        Optional<T> persistedEntity = _repo.findById(id);
        if (persistedEntity.isPresent()) {
            if (entity instanceof User source && persistedEntity.get() instanceof User target) {
                if (source.getEmail() != null) {
                    target.setEmail(source.getEmail());
                }
                if (source.getPassword() != null) {
                    target.setPassword(source.getPassword());
                }
                _repo.save(persistedEntity.get());
            } else {
                throw new RuntimeException("id " + id + " not found");
            }
        }
    }

    public void delete(Integer id) {
        if (_repo.findById(id).isPresent()) {
            _repo.deleteById(id);
        } else {
            throw new RuntimeException("id " + id + " not found");
        }
    }

    public List<T> get() {
        return _repo.findAll();
    }

    public T get(Integer id) {
        Optional<T> temp = _repo.findById(id);
        if (temp.isPresent()) {
            return temp.get();
        } else {
            throw new RuntimeException("id " + id + " not found");
        }
    }

}














