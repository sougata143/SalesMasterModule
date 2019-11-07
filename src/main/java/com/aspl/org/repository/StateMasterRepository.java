package com.aspl.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.StateMaster;

@Repository
public interface StateMasterRepository extends JpaRepository<StateMaster, Integer> {

}
