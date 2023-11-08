package Spring_ex.demo.repository;

import java.util.*;

import Spring_ex.demo.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
