package com.autodoc.server.member;

import com.autodoc.server.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
public class MemberDto {
    @Getter
    public static class Post{
        @NotBlank
        @Email(message = "이메일 형식이 아닙니다.")
        private String email;

        @NotBlank
        private String password;
    }
}
