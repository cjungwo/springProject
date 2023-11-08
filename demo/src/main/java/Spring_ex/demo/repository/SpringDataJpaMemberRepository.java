package Spring_ex.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_ex.demo.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
