package com.demo.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.mobile.dto.RequestsProjections;
import com.demo.mobile.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

	@Query("select cs.customerName as customerName,cs.adharNumber as adharNumber ,cs.newConnectionNumber as newConnectionNumber ,cs.address as address,cs.planName as planName,s.requestId as requestId,s.status as status,s.date as date from Customers as cs inner join Status as s on cs.customerId=s.customerId and s.status='In Progress'")
	public List<RequestsProjections> getNewConnectionSubmittedRequests();

}
