package com.autodoc.server.Document.DTO;

import com.autodoc.server.Document.Entity.DocumentEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor //생성자 자동생성
@ToString //투스트링 자동생성
public class DocumentDto {

    private Long id; // PK
    private String title; // 제목
    private String destinationOfTrip; // 출장지
    private String dateOfTrip; // 출장기간
    private String purposeOfTrip; // 출장 목적
    private Date deadline; // 제출 날자
    private String approval; // 결재란
    private Long member_id; // 멤버 id



    public DocumentEntity toEntity() { //DTO를 ENTITY로 변환
        return new DocumentEntity(id, title, destinationOfTrip, dateOfTrip, purposeOfTrip, deadline, approval, member_id);
    }
}


