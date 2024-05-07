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

    // CREATE
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // READ
    public List<Member> getMember() {
        return memberRepository.findAll();
    }

    // DELETE
    public void deleteMember(long id) {
        memberRepository.deleteById((int) id);

    }

    // UPDATE
    public Member updateMember(long id, Member member) {
        Member member1 = memberRepository.findById((int) id).get();
        member1.setName(member.getName());
        member1.setContact(member.getContact());
        member1.setMember_id(member.getMember_id());

        return memberRepository.save(member1);
    }
}
