package com.autodoc.server.Document.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity //엔티티 선언
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter

public class DocumentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String title;

    @Column()
    private String destinationOfTrip; // 출장지

    @Column()
    private String dateOfTrip; // 출장기간

    @Column()
    private String purposeOfTrip; // 출장 목적

    @Column()
    private Date deadline; // 제출 날자

    @Column()
    private String approval; // 결재란

    @Column()
    private Integer member_id; // 멤버 id




    public void patch(DocumentEntity documentEntity) { //null 버그 해결
        if (documentEntity.getTitle()!= null) {
            this.title = documentEntity.getTitle();
        }
        if (documentEntity.getDestinationOfTrip()!= null) {
            this.destinationOfTrip = documentEntity.getDestinationOfTrip();
        }
        if (documentEntity.getDateOfTrip()!= null) {
            this.dateOfTrip = documentEntity.getDateOfTrip();
        }
        if (documentEntity.getPurposeOfTrip()!= null) {
            this.purposeOfTrip = documentEntity.getPurposeOfTrip();
        }
        if (documentEntity.getDeadline()!= null) {
            this.deadline = documentEntity.getDeadline();
        }
        if (documentEntity.getApproval()!= null) {
            this.approval = documentEntity.getApproval();
        }
        if (documentEntity.getMember_id()!= null) {
            this.member_id = documentEntity.getMember_id();
        }
    }
}
