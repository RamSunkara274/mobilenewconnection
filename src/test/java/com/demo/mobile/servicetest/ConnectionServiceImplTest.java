package com.demo.mobile.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.mobile.dto.ConnectionsDto;
import com.demo.mobile.entity.Connections;
import com.demo.mobile.entity.Plans;
import com.demo.mobile.entity.Status;
import com.demo.mobile.repository.ConnectionRepository;
import com.demo.mobile.repository.CustomersRepository;
import com.demo.mobile.repository.PlansRepository;
import com.demo.mobile.repository.StatusRepository;
import com.demo.mobile.serviceimpl.ConnectionServiceImpl;

@RunWith(PowerMockRunner.class)
public class ConnectionServiceImplTest {

	@Mock
	ConnectionRepository connectionRepo;

	@InjectMocks
	ConnectionServiceImpl connectionServiceImpl;

	@Mock
	StatusRepository statusRepo;
	@Mock
	PlansRepository plansRepo;

	@Mock
	CustomersRepository customerRepo;

	@Test
	public void findCustomerStatus() {
		Status sts = new Status();
		sts.setStatus("Approved");
		Mockito.when(statusRepo.findByRequestId(Mockito.anyInt())).thenReturn(sts);
		assertEquals("Approved", sts.getStatus());
	}

	@Test
	public void getAllPlansFronDB() {
		Plans plan = new Plans();
		List<Plans> listOfPlans = new ArrayList<Plans>();
		plan.setPlanName("ABC");
		listOfPlans.add(plan);
		Mockito.when(plansRepo.findAll()).thenReturn(listOfPlans);
		assertEquals(1, listOfPlans.size());

	}

	@Test
	public void getAllConnections() {

		Connections connectionEntity = new Connections();
		connectionEntity.setNumber("98739097830");
		List<Connections> listOfConnection = new ArrayList<Connections>();
		listOfConnection.add(connectionEntity);
		Mockito.when(connectionRepo.findAll()).thenReturn(listOfConnection);
		assertEquals(1, listOfConnection.size());

	}

}
