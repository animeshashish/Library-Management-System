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

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<Member> getMember() {
        return memberService.getMember();
    }
    @RequestMapping(value = "/members/{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable(value = "id") Long id) {
        memberService.deleteMember(id);
    }
    @RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
    public Member updateMember(@PathVariable(value = "id") Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

}
