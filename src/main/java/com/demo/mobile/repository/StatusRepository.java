package com.demo.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mobile.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

	Status findByRequestId(int requestId);

}
