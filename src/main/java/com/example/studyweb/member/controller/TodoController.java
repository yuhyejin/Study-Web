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
    public String insertTodo (@RequestBody TaskDto taskDto, HttpSession session) {
        taskService.save(taskDto, session);
        System.out.println("할일 등록!");
        return "InsertSuccess";
    }

    @GetMapping("/todoList")
    public String todoList(Model model, HttpSession session) {
        System.out.println("되나,,???");
        if(session.getAttribute("loginEmail") != null) {
            List<TaskDto> taskDtoList = taskService.todoList(session);
            model.addAttribute("todoList", taskDtoList);
            for(TaskDto data: taskDtoList){
                System.out.println(data); //콘솔 출력
            }
            return "pages/todo";
        }
        else
            System.out.println("왜안돼에에에ㅔ");
            return null;
    }



}
