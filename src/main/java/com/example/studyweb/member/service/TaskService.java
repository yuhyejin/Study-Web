package com.example.studyweb.member.service;


import com.example.studyweb.member.dto.TaskDto;
import com.example.studyweb.member.entity.Task;
import com.example.studyweb.member.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Long save(TaskDto taskDto, HttpSession session) {
        Task task = Task.tasksaveEntity(taskDto, session);
        task.setEmail((String)session.getAttribute("loginEmail"));
        Long toinsertId = taskRepository.save(task).getTaskid();
        return toinsertId;

    }

}
