package com.demo.mobile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.mobile.dto.AdminValidateRequestDto;
import com.demo.mobile.dto.ConnectionsDto;
import com.demo.mobile.dto.NewConnectionAppplication;
import com.demo.mobile.dto.RequestsProjections;
import com.demo.mobile.dto.ResponseDto;
import com.demo.mobile.entity.Plans;
import com.demo.mobile.entity.Status;

@Service
public interface ConnectionService {

	public List<ConnectionsDto> getAvailableConnections();

	public ResponseDto registerNewConnection(NewConnectionAppplication newConnection);

	public Status findCustomerStatus(int statusId);

	public List<Plans> getPlansFromDB();

	public List<RequestsProjections> getAllSubmittedRequest();

	public ResponseDto adminValidateNewConnection(AdminValidateRequestDto adminValidateDto);

}
