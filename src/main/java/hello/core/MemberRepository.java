package hello.core;

public interface MemberRepository {

    void save(Member member);
    Member findByID(Long memberId);
}
