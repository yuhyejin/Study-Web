package com.example.studyweb.member.entity;

import com.example.studyweb.member.dto.MyGroupDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@Table(name = "mygroup")
public class MyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "GROUPSTUDY_ID")
    private Group gstudy;

    public MyGroup() {
    }

    public MyGroup(String email, Group gstudy) {
        this.email = email;
        this.gstudy = gstudy;
    }




    public static MyGroup myGroupSaveEntity(MyGroupDto myGroupDto, Group gstudy) {
        MyGroup myGroup = new MyGroup();
        myGroup.setEmail(myGroupDto.getEmail());
        myGroup.setGstudy(gstudy);
        return myGroup;
    }

}
