package com.Library.Management.System.service;

import com.Library.Management.System.Repository.MemberRepository;
import com.Library.Management.System.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    // creating/saving a specific record using save() method
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // getting all member record using findAll() method
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    // getting a specific record using findById() method
    public Member getMemberById(int id) {
        return memberRepository.findById(id).get();
    }

    // deleting a specific record by using deleteById() method
    public void deleteMember(int id) {
        memberRepository.deleteById(id);

    }

    // UPDATE
    public Member updateMember(int id, Member member) {
        Member member1 = memberRepository.findById(id).get();
        member1.setName(member.getName());
        member1.setContact(member.getContact());
        member1.setMemberId(member.getMemberId());

        return memberRepository.save(member1);
    }
}
