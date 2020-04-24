package com.manager.repository;

import com.manager.domain.project.Project;
import com.manager.domain.project.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, ProjectId> {

    @Query(value = "SELECT max(id) + 1 as id FROM project LIMIT 1", nativeQuery = true)
    Long nextId();
}
