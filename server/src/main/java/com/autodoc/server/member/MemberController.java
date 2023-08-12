package com.autodoc.server.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity createMember(@RequestBody @Valid MemberDto.Post requestBody){

        Member response = memberService.createMember(memberMapper.memberPostToMember(requestBody));

        return new ResponseEntity<>(memberMapper.memberToMemberResponse(response), HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable long memberId){
        Member response = memberService.findMember(memberId);

        return new ResponseEntity(memberMapper.memberToMemberResponse(response), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity getMembers(){
//
//
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @PatchMapping("/{member-id}")
    public ResponseEntity updateMember(@PathVariable long memberId,
                                       @RequestBody MemberDto.Patch requestBody){
        requestBody.setId(memberId);
        Member response = memberService.updateMember(memberMapper.memberPatchTOMember(requestBody));

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable long memberId){
        memberService.deleteMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
