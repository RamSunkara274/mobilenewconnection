package com.demo.mobile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mobile.dto.UserStatus;
import com.demo.mobile.entity.UStatus;

@Repository
public interface UstatusRepository extends JpaRepository<UStatus, Long> {

	Optional<UStatus> findByName(UserStatus name);

}
