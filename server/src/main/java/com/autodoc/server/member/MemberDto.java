package com.autodoc.server.member;

import com.autodoc.server.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@NoArgsConstructor
public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        @Email(message = "이메일 형식이 아닙니다.")
        private String email;

        @NotBlank(message = "패스워드를 비울 수 없습니다.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$")
        private String password;

        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{

        @Setter
        private Long id;

        private String password;

        private String name;

        private String phoneNumber;

        private String companyName;

        private String department;

        private String rankOfCompany;

        private Integer dailyExpense;

        private String signStamp;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class response{
        private String email;

        private String name;

        private String phoneNumber;

        private String companyName;

        private String department;

        private String rankOfCompany;

        private Integer dailyExpense;

        private String signStamp;
    }
}
