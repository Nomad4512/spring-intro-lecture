package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 안된다.
        /*Optional<Member> result = memberRepository.findByName(member.getName()); // com+opt+v
                                            // optional로 감싸서 ifPresent 가능, 꺼내고싶으면 .get();
        result.ifPresent(m ->{ // null이 아니라 값이 있으면
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */ //Optional로 바로 반환하는거 좋지 않아서 아래와같이 권장
        validateDuplicateMember(member); // 아래 작성 후 opt+com+m 으로 메서드 추출. 중복회원 검

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
