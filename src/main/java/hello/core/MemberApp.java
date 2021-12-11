package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl(memberRepository);
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);  //appConfig에 있는 객체들을 스프링에서 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //ist param : appconfig에서의 메소드명 / 2nd param : 리턴 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
