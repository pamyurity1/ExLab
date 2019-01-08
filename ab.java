package com.example.demo.entity;

import javax.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table (name = "User")
@Getter
@Setter
public class user {
    @Id
    @SequenceGenerator(name="user_seq",sequenceName="user_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    @Column(name="user_ID",unique = true, nullable = false)
    private Long iduse;
    private String name;
    private String email;
    private String sex;



    public user(String email,String name,String sex){
        this.email = email;
        this.name = name;
        this.sex = sex;
    }


    @OneToMany(
            mappedBy="user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Bill> bill = new ArrayList<>();

    @OneToMany(
            mappedBy="user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<review> review = new ArrayList<>();
}
