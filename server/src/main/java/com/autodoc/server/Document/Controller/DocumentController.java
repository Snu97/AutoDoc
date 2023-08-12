package com.autodoc.server.Document.Controller;

import com.autodoc.server.Document.DTO.DocumentDto;
import com.autodoc.server.Document.Entity.DocumentEntity;
import com.autodoc.server.Document.Repository.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@ResponseStatus
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;


    @PostMapping("/documents")
    public String createDocument(@RequestBody DocumentDto dto) {
        log.info(dto.toString());

        // DTO -> ENTITY
        DocumentEntity entity = dto.toEntity();
        log.info(entity.toString());

        // ENTITY -> DB
        DocumentRepository.save(entity);
    }
}
