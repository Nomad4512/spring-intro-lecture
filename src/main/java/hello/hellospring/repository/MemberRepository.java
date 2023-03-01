package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장
    Optional<Member> findById(Long id); // 찾기
    Optional<Member> findByName(String name); // 찾기
    List<Member> findAll(); // 저장한 모든 리스트 반환
}
