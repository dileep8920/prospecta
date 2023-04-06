package com.prospecta.problem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.problem1.model.Entry;


@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer>{

}
