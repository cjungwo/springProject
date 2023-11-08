package Spring_ex.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Spring_ex.demo.domain.Member;
import Spring_ex.demo.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    // Constructor Injection -> 권장
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Setter Injection -> 지양
    // @Autowired
    // public void setMemberController(MemberService memberService) {
    //     this.memberService = memberService;
    // }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println(member);
        
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
