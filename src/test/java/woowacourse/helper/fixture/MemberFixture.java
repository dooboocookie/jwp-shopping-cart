package woowacourse.helper.fixture;

import woowacourse.exception.dto.ErrorResponse;
import woowacourse.member.domain.Member;
import woowacourse.member.dto.MemberRegisterRequest;
import woowacourse.member.infrastructure.PasswordEncoder;
import woowacourse.member.infrastructure.PasswordValidator;
import woowacourse.member.infrastructure.SHA256PasswordEncoder;

public class MemberFixture {

    public static final String EMAIL = "member@gmail.com";
    public static final String PASSWORD = "Member1234!";
    public static final String NAME = "member";
    public static final String ENCODE_PASSWORD = "99a4c71c3553b29f63b9931c027cdc1afb12f545f78258e62a8fac043d9af89f";
    public static final String BEARER = "Bearer ";
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjUzODIwOTg2LCJleHAiOjE2NTM4MjQ1ODZ9.le7-3iZnWEAn1OwoMnIJl8UXfg1t5Tnpog58kV89f1c";
    public static final String UNAUTHORIZED_MESSAGE = "[ERROR] 인증이 되지 않은 유저입니다.";
    public static final ErrorResponse TOKEN_ERROR_RESPONSE = new ErrorResponse("[ERROR] 토큰이 올바르지 않습니다.");

    public static Member createMember(String email, String password, String name) {
        return Member.createMemberWithPasswordEncode(email, password, name, passwordEncoder());
    }

    public static MemberRegisterRequest createMemberRegisterRequest(String email, String password, String name) {
        return new MemberRegisterRequest(email, password, name);
    }

    public static PasswordEncoder passwordEncoder() {
        return new SHA256PasswordEncoder(new PasswordValidator());
    }
}