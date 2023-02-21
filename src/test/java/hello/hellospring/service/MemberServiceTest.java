package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("changho Youn");

        //when
        Long saveId = memberService.join(member);

        //then
        Member member1 = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(member1.getName() );
    }

    @Test
    public void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("hi");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("hi");


        Assertions.assertThatIllegalStateException().isThrownBy(()->memberService.join(member2));
        /* try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}