package com.example.studyweb.member.controller;

import com.example.studyweb.member.dto.GroupDto;
import com.example.studyweb.member.dto.MyGroupDto;
import com.example.studyweb.member.service.GroupService;
import com.example.studyweb.member.service.MyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private final GroupService groupService;
    private final MyGroupService myGroupService;


    @PostMapping("/save-group")
    public String saveGroup (@RequestBody GroupDto groupDto, HttpSession session) {
        groupDto.setEmail((String) session.getAttribute("loginEmail"));
        groupDto.setNickname((String) session.getAttribute("nickName"));
        groupService.save(groupDto);
        System.out.println("그룹 추가!");
        return "SaveSuccess";
    }

    @PostMapping ("/save-mygroup")
    public String mySaveGroup (@RequestBody MyGroupDto myGroupDto, HttpSession session) {
//        Long id = Long.parseLong("group_seq");
        myGroupDto.setEmail((String) session.getAttribute("loginEmail"));
        myGroupService.mySave(myGroupDto);
        System.out.println("나의 그룹 추가!");
        return "hi";
    }


    @GetMapping("/group-list")
    public ModelAndView listAll(Model model) {
        ModelAndView mv = new ModelAndView();
        List<GroupDto> groupList = groupService.groupAllList();
        //List<MyGroupDto> myGroupDtoList = myGroupService.myGroupAllList();
        model.addAttribute("GroupList", groupList);
      //  model.addAttribute("myGroupList", myGroupDtoList);
        mv.setViewName("pages/groupstudy");
        mv.addObject("GroupList", groupList);
        //mv.addObject("myGroupList", myGroupDtoList);
        System.out.println("리스트 완료!");
        return mv;
    }



}
