package com.example.studyweb.member.dto;

import com.example.studyweb.member.entity.Group;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class GroupDto {

    private Long id;

    @NotNull
    private String email;

    private  String nickname;

    @NotNull
    private String groupname;

    private String category;

    private String goaltime;

    private String people;

    private String grouppassword;

    private String groupinfo;

    public static GroupDto toGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setEmail(group.getEmail());
        groupDto.setNickname(group.getNickname());
        groupDto.setGroupname(group.getGroupname());
        groupDto.setCategory(group.getCategory());
        groupDto.setGoaltime(group.getGoaltime());
        groupDto.setPeople(group.getPeople());
        groupDto.setGrouppassword(group.getGrouppassword());
        groupDto.setGroupinfo(group.getGroupinfo());
        return groupDto;
    }

}
