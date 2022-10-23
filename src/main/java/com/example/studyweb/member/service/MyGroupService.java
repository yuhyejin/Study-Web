package com.example.studyweb.member.service;


import com.example.studyweb.member.dto.MyGroupDto;
import com.example.studyweb.member.entity.Group;
import com.example.studyweb.member.entity.MyGroup;
import com.example.studyweb.member.repository.MyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyGroupService {

    private final MyGroupRepository myGroupRepository;
    private final GroupService groupService;

    public void mySave(MyGroupDto myGroupDto) {
        Group group = groupService.findGroupById(myGroupDto.getId());
        MyGroup myGroup = MyGroup.myGroupSaveEntity(myGroupDto,group);
        myGroupRepository.save(myGroup);
       // Long myId = myGroupRepository.save(myGroup).getGstudy().getId();
    }

    public List<MyGroupDto> myGroupAllList() {
        List<MyGroup> myGroupList = myGroupRepository.findAll();
        List<MyGroupDto> myGroupDtoList = new ArrayList<>();
        for (MyGroup myGroup: myGroupList) {
            MyGroupDto myGroupDto = MyGroupDto.toMyGroupDto(myGroup);
            myGroupDtoList.add(myGroupDto);
        }
        return myGroupDtoList;
    }


}
