package com.example.studyweb.member.repository;

import com.example.studyweb.member.entity.MyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyGroupRepository extends JpaRepository<MyGroup, Long> {

}
