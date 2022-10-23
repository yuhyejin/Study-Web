package com.example.studyweb.member.repository;

import com.example.studyweb.member.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {


    Optional<Group> findByEmail(String email);

    Group findGroupById(Long id);
}
