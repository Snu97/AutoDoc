package com.autodoc.server.member;

import com.autodoc.server.exception.BusinessLogicException;
import com.autodoc.server.exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService  {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member){
        verifyExitsMember(member.getEmail());
        Member response = memberRepository.save(member);

        return response;
    }

    public Member findMember(Long memberId){
        Member response = verifyMember(memberId);

        return response;
    }

//    public Member findMembers(){
//        return;
//    }

    public Member updateMember(Member member){
        Member response = verifyMember(member.getMemberId());

        return response;
    }

    public void deleteMember(long memberId){
        Member response = verifyMember(memberId);

        memberRepository.delete(response);

    }

    private Member verifyMember(Long memberId){
        Optional<Member> member = memberRepository.findById(memberId);

        if(member.isPresent())
            return member.get();

        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }

    private void verifyExitsMember(String email){
        Optional<Member> member = memberRepository.findByEmail(email);

        if(member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

}
