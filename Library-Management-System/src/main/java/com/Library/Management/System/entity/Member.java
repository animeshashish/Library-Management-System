package com.Library.Management.System.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Member")

public class Member {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Name")
   private String name;
    @Column(name = "Contact")
  private   String contact;
    @Column(name = "Member ID")
   private String memberId;


    public Member(int id, String name, String contact, String memberId) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.memberId = memberId;
    }

    public Member() { // Default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}


