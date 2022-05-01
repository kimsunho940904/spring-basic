package hello.core.member;

public interface MemberRepository {
    //저장
    void save(Member member);

    //조회
    Member findById(Long memberId);
}
