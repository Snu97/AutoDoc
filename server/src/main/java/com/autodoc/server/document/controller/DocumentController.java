package com.autodoc.server.document.controller;

import com.autodoc.server.document.dto.DocumentDto;
import com.autodoc.server.document.entity.DocumentEntity;
import com.autodoc.server.document.repository.DocumentRepository;
import com.autodoc.server.document.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@ResponseStatus
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    // Document 전체조회
    @GetMapping("/api/document")
    public List<DocumentEntity> getDocument() {
        return documentService.getDocument();
    }
    // Document 상세조회
    @GetMapping("/api/document/{id}")
    public DocumentEntity findDocumentByDetail(@PathVariable Long id) {
        return documentService.findDocument(id);
    }

}
