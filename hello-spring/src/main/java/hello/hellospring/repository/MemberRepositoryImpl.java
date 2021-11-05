package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemberRepositoryImpl implements MemberRepository {
    // 저장할 곳이 필요하니, 회원의 아이디 : long 값 : member
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 널 값이 있을 수 있으니 처리해주기.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {

        //루프로 돌리면서, member에 name이 파라미터로 넘어온 name과 같은지 확인.
        //같은 경우에만 필터링 되면서, 찾으면 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }


    @Override
    public List<Member> findAll() {
        // 스토어에 있는 values(member)들을 반환
        return new ArrayList<>(store.values());
    }
}
