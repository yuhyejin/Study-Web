package com.example.studyweb.member.repository;

import com.example.studyweb.member.entity.MemberEntity;
import com.example.studyweb.member.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByEmail(String email);


}
