package com.demo.mobile.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mobile.dto.AdminValidateRequestDto;
import com.demo.mobile.dto.ConnectionsDto;
import com.demo.mobile.dto.NewConnectionAppplication;
import com.demo.mobile.dto.RequestsProjections;
import com.demo.mobile.dto.ResponseDto;
import com.demo.mobile.entity.Plans;
import com.demo.mobile.entity.Status;
import com.demo.mobile.service.ConnectionService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ConnectionController {

	@Autowired
	ConnectionService connectionService;

	Logger logger = LoggerFactory.getLogger(ConnectionController.class);

	@ApiOperation("Here we are getting the all available mobile numbers")
	@GetMapping("/connections")
	public List<ConnectionsDto> getAllMobileNumbers() {

		logger.info("getting all the available new connections in ConnectionController.class");
		return connectionService.getAvailableConnections();

	}

	@ApiOperation("customer new connection details mapping to database")
	@PostMapping("/register")
	public ResponseDto newConnectionRegister(@RequestBody NewConnectionAppplication newConnection) {
		logger.info("mapping new connection user details to Database in  ConnectionController.class");
		return connectionService.registerNewConnection(newConnection);

	}

	@ApiOperation("getting the customer new connection status")
	@GetMapping("/status")
	public Status getCustomerStatus(int statusId) {
		logger.info("getting the customer status details  in  ConnectionController.class");
		return connectionService.findCustomerStatus(statusId);

	}

	@ApiOperation("Getting all the available plans for new connection")
	@GetMapping("/plans")
	public List<Plans> getAvailablePlans() {
		logger.info("getting all available plan details  in in ConnectionController.class");
		return connectionService.getPlansFromDB();

	}

	@ApiOperation("Getting all the new connection requests to see the admin")
	@GetMapping("/admin/requests")
	public List<RequestsProjections> getAllRequests() {
		logger.info("getting all the submitted requets in in ConnectionController.class");
		return connectionService.getAllSubmittedRequest();

	}

	@ApiOperation("Admin validating the new connection requests")
	@PutMapping("/admin")
	public ResponseDto adminValidateRequest(@RequestBody AdminValidateRequestDto adminValidateDto) {
		logger.info("admin validating the requtes whether it is valid or invalid in in ConnectionController.class");
		return connectionService.adminValidateNewConnection(adminValidateDto);

	}

}
