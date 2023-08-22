package com.autodoc.server.document.repository;

import com.autodoc.server.document.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DocumentRepository extends CrudRepository<DocumentEntity, Long> {

    @Override
    ArrayList<DocumentEntity> findAll(); // findAll 메소드의 리턴타입을 어레이리스트로 오버라이드

}
