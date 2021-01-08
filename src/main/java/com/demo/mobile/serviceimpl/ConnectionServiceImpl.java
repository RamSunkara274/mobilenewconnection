package com.demo.mobile.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.mobile.dto.AdminValidateRequestDto;
import com.demo.mobile.dto.ConnectionsDto;
import com.demo.mobile.dto.NewConnectionAppplication;
import com.demo.mobile.dto.RequestsProjections;
import com.demo.mobile.dto.ResponseDto;
import com.demo.mobile.entity.Connections;
import com.demo.mobile.entity.Customers;
import com.demo.mobile.entity.Plans;
import com.demo.mobile.entity.Status;
import com.demo.mobile.repository.ConnectionRepository;
import com.demo.mobile.repository.CustomersRepository;
import com.demo.mobile.repository.PlansRepository;
import com.demo.mobile.repository.StatusRepository;
import com.demo.mobile.service.ConnectionService;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionRepository connectionRepo;

	@Autowired
	CustomersRepository customerRepo;

	@Autowired
	StatusRepository statusRepo;

	@Autowired
	PlansRepository plansRepo;

	ModelMapper modelMapper = new ModelMapper();

	Logger logger = LoggerFactory.getLogger(ConnectionServiceImpl.class);

	@Override
	public List<ConnectionsDto> getAvailableConnections() {
		List<Connections> listOfConnections = connectionRepo.findAll();

		logger.info("getting all the available new connections in ConnectionServiceImpl class");
		List<ConnectionsDto> listOfDto = new ArrayList<ConnectionsDto>();

		for (Connections dto : listOfConnections) {
			logger.info("Iterate the all the available new connections in ConnectionServiceImpl class");
			ConnectionsDto object = new ConnectionsDto();
			object.setConnectionId(dto.getConnectionId());
			object.setNumber(dto.getNumber());
			listOfDto.add(object);
		}

		/*
		 * Here bean utils are not working because of that reason i used for
		 * each loop
		 */

		// BeanUtils.copyProperties(listOfDto, listOfConnections);
		return listOfDto;

	}

	@Override
	public ResponseDto registerNewConnection(NewConnectionAppplication newConnection) {

		logger.info("mapping new connection user details to Database in ConnectionServiceImpl class");

		if (newConnection.getAddress().isEmpty() || newConnection.getAdharNumber().isEmpty()
				|| newConnection.getCustomerName().isEmpty() || newConnection.getNewConnectionNumber().isEmpty()
				|| newConnection.getAddress().isEmpty()) {

			logger.info("validating all the fields in ConnectionServiceImpl ");
			ResponseDto response = new ResponseDto();
			response.setMessage("Please enter the all the fields,it cannot be empty");
			response.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return response;
		}

		Customers customerEntity = new Customers();

		BeanUtils.copyProperties(newConnection, customerEntity);

		customerRepo.save(customerEntity);

		Random ran = new Random();
		int randomId = ran.nextInt(89863534);

		Status statusEntity = new Status();
		statusEntity.setRequestId(randomId);
		statusEntity.setStatus("In Progress");
		statusEntity.setDate(LocalDate.now());
		Long customerId = customerEntity.getCustomerId();
		statusEntity.setCustomerId(customerId);

		statusRepo.save(statusEntity);

		String connectionNewNumber = newConnection.getNewConnectionNumber();
		Connections connectionEntity = connectionRepo.findByNumber(connectionNewNumber);
		connectionRepo.deleteById(connectionEntity.getConnectionId());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(
				"Your details uploaded sucessfully...your connection will activate soon and if any problem willl occur we will reach to you");
		responseDto.setRequestId(randomId);
		responseDto.setStatusCode(HttpStatus.ACCEPTED.value());

		return responseDto;
	}

	@Override
	public Status findCustomerStatus(int requestId) {

		logger.info("getting the customer status details  in ConnectionServiceImpl class");
		return statusRepo.findByRequestId(requestId);
	}

	@Override
	public List<Plans> getPlansFromDB() {

		logger.info("getting all available plan details  in ConnectionServiceImpl class");
		return plansRepo.findAll();
	}

	@Override
	public List<RequestsProjections> getAllSubmittedRequest() {
		logger.info("getting all the submitted requets in ConnectionServiceImpl class");
		return customerRepo.getNewConnectionSubmittedRequests();
	}

	@Override
	public ResponseDto adminValidateNewConnection(AdminValidateRequestDto adminValidateDto) {

		Status statusEntity = statusRepo.findByRequestId(adminValidateDto.getRequestId());

		statusEntity.setStatus(adminValidateDto.getStatus());
		logger.info("admin validating the requtes whether it is valid or invalid in ConnectionServiceImpl class");

		statusRepo.save(statusEntity);

		ResponseDto responseDto = new ResponseDto();

		responseDto.setMessage("The admin changed new connection status to " + adminValidateDto.getStatus());
		responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return responseDto;
	}

}
