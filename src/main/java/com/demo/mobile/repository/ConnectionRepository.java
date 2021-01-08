package com.demo.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mobile.entity.Connections;

@Repository
public interface ConnectionRepository extends JpaRepository<Connections, Long> {

	List<Connections> findAll();

	void deleteByNumber(String number);

	Connections findByNumber(String connectionNewNumber);
}
