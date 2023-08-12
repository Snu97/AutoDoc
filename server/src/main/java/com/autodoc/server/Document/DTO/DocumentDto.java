package com.autodoc.server.Document.DTO;

import com.autodoc.server.Document.Entity.DocumentEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class DocumentDto {

    private Long id; // PK
    private String title; // 제목
    private String destinationOfTrip; // 출장지
    private String dateOfTrip; // 출장기간
    private String purposeOfTrip; // 출장 목적
    private Date deadline; // 제출 날자
    private String approval; // 결재란
    private Integer member_id; // 멤버 id



    public DocumentEntity toEntity() {
        return new DocumentEntity(id, title, destinationOfTrip, dateOfTrip, purposeOfTrip, deadline, approval, member_id);
    }
}


