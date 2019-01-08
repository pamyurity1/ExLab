package com.example.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Bills")
@Data

@ToString @EqualsAndHashCode
public class Bill {

    public Long getId_bill() {
        return id_bill;
    }

    public void setId_bill(Long id_bill) {
        this.id_bill = id_bill;
    }

    public com.example.demo.entity.user getUser() {
        return user;
    }

    public void setUser(com.example.demo.entity.user user) {
        this.user = user;
    }

    public List<com.example.demo.entity.room> getRoom() {
        return room;
    }

    public void setRoom(List<com.example.demo.entity.room> room) {
        this.room = room;
    }

    @Id
    @SequenceGenerator(name="bill_seq",sequenceName="bill_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bill_seq")
    @Column(name="bill_ID",unique = true, nullable = false)
    private Long id_bill;



    @ManyToOne(fetch = FetchType.LAZY)
    private user user;

    @OneToMany(
            mappedBy="bill",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<room> room = new ArrayList<>();



    public Bill(user user){
        this.user = user;
    }


}
