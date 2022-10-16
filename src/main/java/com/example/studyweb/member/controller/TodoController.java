package com.example.studyweb.member.controller;

import com.example.studyweb.member.dto.TaskDto;
import com.example.studyweb.member.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private final TaskService taskService;

    @PostMapping("/inserttodo")
    public String insertTodo (@RequestBody TaskDto taskDto) {
        taskService.save(taskDto);
        System.out.println("할일 등록!");
        return "InsertSuccess";
    }

    @GetMapping("/todList")
    public List<TaskDto> todoList(Model model, HttpSession session) {
        if(session.getAttribute("loginEmail") != null) {
            List<TaskDto> taskDtoList = taskService.todoList();
            model.addAttribute("todoList", taskDtoList);
            return taskDtoList;
        }
        else
            return null;
    }



}
