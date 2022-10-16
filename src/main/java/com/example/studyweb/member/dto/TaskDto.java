package com.example.studyweb.member.dto;

import com.example.studyweb.member.entity.MemberEntity;
import com.example.studyweb.member.entity.Task;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class TaskDto {


    private Long taskid;
    @NotNull
    private String email;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private String priority;

    private String curcal;

    public void TaskDto(String email, String title, String description, String priority, String curcal) {
        this.email = email;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.curcal = curcal;
    }

    public static TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskid(task.getTaskid());
        taskDto.setEmail(task.getEmail());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority());
        taskDto.setCurcal(task.getCurcal());
        return taskDto;
    }

}
