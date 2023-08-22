package com.autodoc.server.document.service;

import com.autodoc.server.document.dto.DocumentDto;
import com.autodoc.server.document.entity.DocumentEntity;
import com.autodoc.server.document.repository.DocumentRepository;
import com.autodoc.server.exception.BusinessLogicException;
import com.autodoc.server.exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {


    @Autowired
    private DocumentRepository documentRepository;

    //document 전체조회
    public List<DocumentEntity> getDocument() {
        return documentRepository.findAll();
    }

    //document 단건조회
    public DocumentEntity findDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    // create document

    public DocumentEntity create(DocumentDto dto) {
        DocumentEntity entity = dto.toEntity();

        if (entity.getId() != null) {
            return null;
        }

        //리턴
        return documentRepository.save(entity);
    }

    //document 삭제
    public DocumentEntity delete(Long id) {
        DocumentEntity entity = documentRepository.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }
        documentRepository.delete(entity);
        return entity;
    }

}
