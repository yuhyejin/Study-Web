package com.example.studyweb.member.service;


import com.example.studyweb.member.dto.TaskDto;
import com.example.studyweb.member.entity.Task;
import com.example.studyweb.member.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Long save(TaskDto taskDto) {
        Task task = Task.tasksaveEntity(taskDto);
        Long toinsertId = taskRepository.save(task).getTaskid();
        return toinsertId;

    }

    public List<TaskDto> todoList() {
        List<Task> taskList = taskRepository.findAll();
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (Task task: taskList) {
            TaskDto taskDto = TaskDto.toTaskDto(task);
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }


}
