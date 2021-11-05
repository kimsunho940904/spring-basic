package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> , MemberRepository {
    // JpaRepository<Member, Long> = key = Member, id = Long 멤버의 아이디는 롱 타입
    Optional<Member> findByName(String name);
}
