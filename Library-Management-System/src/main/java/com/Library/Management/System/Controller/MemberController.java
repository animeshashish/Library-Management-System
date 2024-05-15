package com.Library.Management.System.Controller;

import com.Library.Management.System.entity.Member;
import com.Library.Management.System.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")

public class MemberController {
    @Autowired
    MemberService memberService;
    // creating post mapping that post the member in database

    @PostMapping("/members")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    // creating get mapping that retrieves all the members from database
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // creating get mapping that retrieves a specific member from database
    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable ("id") int id) {
        return memberService.getMemberById(id);
    }


    // creating delete mapping that deletes a specific record
    public void deleteMember(@PathVariable("id") int id) {
        memberService.deleteMember(id);
    }

    // creating put mapping to update member details
    @PutMapping("members/{id}")
    public Member updateMember(@PathVariable("id") int id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

}
