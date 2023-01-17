package com.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.Documents;

@Repository
public interface RE_Documents_Repository extends JpaRepository<Documents, Integer> {

}
