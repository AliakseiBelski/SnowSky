package com.tryam.study.repository;

import com.tryam.study.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository {

    @Query(value = "SELECT * FROM users WHERE names = :name", nativeQuery = true)
    User findByName(@Param("name") String name);

}