package com.demo.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mobile.entity.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long> {

}
