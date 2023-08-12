package com.autodoc.server.member;

import com.autodoc.server.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 30, nullable = false, updatable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;


    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = true)
    private String phoneNumber;

    @Column(length = 20, nullable = true)
    private String companyName;

    @Column(length = 20, nullable = true)
    private String department;

    @Column(length = 10, nullable = true)
    private String rankOfCompany;

    @Column(nullable = true)
    private Integer dailyExpense;

    @Column(length = 200, nullable = true)
    private String signStamp;




    //폰, 이름,회사명 일비 서명, 소속, 직급
}
