package com.manager.repository;

import com.manager.domain.user.User;
import com.manager.domain.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {

    @Query(value = "SELECT max(id) + 1 as id FROM user LIMIT 1", nativeQuery = true)
    Long nextId();
}
