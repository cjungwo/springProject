package Spring_ex.demo;

// import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import Spring_ex.demo.aop.TimeTraceAop;
// import Spring_ex.demo.repository.JdbcTemplateMemberRepository;
// import Spring_ex.demo.repository.JpaMemberRepository;
import Spring_ex.demo.repository.MemberRepository;
// import Spring_ex.demo.repository.MemoryMemberRepository;
import Spring_ex.demo.service.MemberService;
// import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {
    // private DataSource dataSource;


    // @Autowired
    // public SpringConfig(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }
    

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository() {
    //     // return new MemoryMemberRepository();
    //     // return new JdbcTemplateMemberRepository(dataSource);
    //     // return new JpaMemberRepository(em);
    // }

    // @Bean
    // public TimeTraceAop timeTraceAop() {
    //     return new TimeTraceAop();
    // }
}
