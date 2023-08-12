package com.autodoc.server.Document.DTO;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class DocumentDto {

    private String id;
    private String title;
    private String destinationOfTrip;
    private String dateOfTrip;
    private String purposeOfTrip;
    private Date deadline;
    private String approval;
}
