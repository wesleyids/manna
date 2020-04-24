package com.manager.repository;

import com.manager.domain.task.Task;
import com.manager.domain.task.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, TaskId> {

    @Query(value = "SELECT max(id) + 1 as id FROM task LIMIT 1", nativeQuery = true)
    Long nextId();
}
