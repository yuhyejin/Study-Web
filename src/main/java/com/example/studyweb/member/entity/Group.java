package com.example.studyweb.member.entity;

import com.example.studyweb.member.dto.GroupDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "gstudy")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String groupname;

    @Column
    private String category;

    @Column
    private String goaltime;

    @Column
    private String people;

    @Column
    private String grouppassword;

    @Column
    private String groupinfo;

    @OneToMany(mappedBy = "gstudy")
    private List<MyGroup> myGroups = new ArrayList<>();


    public Group() {
        this.email = email;
        this.nickname = nickname;
        this.groupname = groupname;
        this.category = category;
        this.goaltime = goaltime;
        this.people = people;
        this.grouppassword = grouppassword;
        this.groupinfo = groupinfo;
        this.myGroups = myGroups;
    }

    public static Group groupsaveEntity(GroupDto groupDto) {
        Group group = new Group();
        group.setEmail(groupDto.getEmail());
        group.setNickname(groupDto.getNickname());
        group.setGroupname(groupDto.getGroupname());
        group.setCategory(groupDto.getCategory());
        group.setGoaltime(groupDto.getGoaltime());
        group.setPeople(groupDto.getPeople());
        group.setGrouppassword(groupDto.getGrouppassword());
        group.setGroupinfo(groupDto.getGroupinfo());
        return group;
    }

}
