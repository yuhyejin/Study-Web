package com.example.studyweb.member.entity;


import com.example.studyweb.member.dto.TaskDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
@Entity
@Getter
@Setter
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskid;

    @Column
    private String email;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private String priority;

    @Column
    private String curcal;

    public Task() {
        this.email = email;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.curcal = curcal;
    }


    public static Task tasksaveEntity(TaskDto taskDto, HttpSession session) {
        Task task = new Task();
        task.setEmail((String) session.getAttribute("loginEmail"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setPriority(taskDto.getPriority());
        task.setCurcal(taskDto.getCurcal());
        return task;
    }
}
