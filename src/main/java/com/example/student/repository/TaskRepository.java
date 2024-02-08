package com.example.student.repository;

import com.example.student.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    List<TaskModel> findByColor(String name);

    @Modifying
    @Transactional
    @Query("UPDATE TaskModel t SET t.description = :description WHERE t.id = :id")
    int updateDescriptionById(@Param("id") Long id, @Param("description") String description);



}
