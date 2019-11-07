package com.aspl.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspl.org.entity.CustomerMaster;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer> {

	List<CustomerMaster> findByStatus(Integer status);
	
}
