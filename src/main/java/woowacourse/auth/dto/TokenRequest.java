package woowacourse.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TokenRequest {

    @NotBlank(message = "이메일에는 공백이 허용되지 않습니다.")
    @Email(message = "올바른 이메일 형식으로 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호에는 공백이 허용되지 않습니다.")
    private String password;

    public TokenRequest() {
    }

    public TokenRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}