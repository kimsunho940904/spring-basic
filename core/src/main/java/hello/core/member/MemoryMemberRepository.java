package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    //저장소니까 저장 할 곳 생성
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // ex)
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //get(memberId) 하면 memberId로 멤버를 찾음.
    }
}
