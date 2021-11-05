package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원이 저장소에 저장
    Member save(Member member);
    // 아이디로 찾기
    Optional<Member> findById(Long id);
    // 이름으로 찾기
    Optional<Member> findByName(String name);
    // 전부 찾기
    List<Member> findAll();


}
