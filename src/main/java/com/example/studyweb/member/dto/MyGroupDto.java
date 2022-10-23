package com.example.studyweb.member.dto;

import com.example.studyweb.member.entity.Group;
import com.example.studyweb.member.entity.MyGroup;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MyGroupDto {

    private Long id;

    private String email;

    private Group gstudy;

    public MyGroupDto() {

    }

    public MyGroupDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public static MyGroupDto toMyGroupDto(MyGroup myGroup) {
        MyGroupDto myGroupDto = new MyGroupDto();
        myGroupDto.setEmail(myGroup.getEmail());
        myGroupDto.setGstudy(myGroup.getGstudy());
        return myGroupDto;
    }
}



