package com.example.studyweb.member.service;

import com.example.studyweb.member.dto.GroupDto;
import com.example.studyweb.member.dto.MyGroupDto;
import com.example.studyweb.member.entity.Group;
import com.example.studyweb.member.entity.MyGroup;
import com.example.studyweb.member.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Long save(GroupDto groupDto) {
        Group group = Group.groupsaveEntity(groupDto);
        Long grosaveId = groupRepository.save(group).getId();
        return grosaveId;
    }



    public List<GroupDto> groupAllList() {
        List<Group> groupList = groupRepository.findAll();
        List<GroupDto> groupDtoList = new ArrayList<>();
        for (Group group: groupList) {
            GroupDto groupDto = GroupDto.toGroupDto(group);
            groupDtoList.add(groupDto);
        }
        return groupDtoList;
    }


    public Group findGroupById(Long id) {
        return groupRepository.findGroupById(id);
    }
}
