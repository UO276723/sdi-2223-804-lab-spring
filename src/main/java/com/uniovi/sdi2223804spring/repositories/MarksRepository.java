package com.uniovi.sdi2223804spring.repositories;
import com.uniovi.sdi2223804spring.entities.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface MarksRepository extends CrudRepository<Mark, Long> {
}

