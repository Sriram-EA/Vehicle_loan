package com.lti.vehicleloan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.appl.vehicleloan.VehicleloanApplication;
import com.lti.appl.vehicleloan.beans.EligibilityChecker;
import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.beans.Vehicle;
import com.lti.appl.vehicleloan.dao.EmiDetailDao;
import com.lti.appl.vehicleloan.dao.EmploymentDao;
import com.lti.appl.vehicleloan.dao.VehicleDao;
import com.lti.appl.vehicleloan.dao.VehicleDaoImpl;
import com.lti.appl.vehicleloan.services.*;


@SpringBootTest(classes=VehicleloanApplication.class)
@TestMethodOrder(OrderAnnotation.class)

class VehicleloanApplicationTests {

	@Autowired
	EligibilityCheckerService eligibilityChecker;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	EmploymentDao employeeDao;
	
	@Autowired
	EmiDetailDao emiDao;
	
	//GetEligibility Form Test cases
	@Test
	@Order(1)
	void contextLoads() {
	
	}

	
	@Test
	@Order(2)
	public void testGetVehicleById()
	{
		
		Vehicle vehicle=vehicleDao.getVehicleById(102);
		
		assertEquals("2W",vehicle.getVehicleType());
	}
	
	@Test
	@Order(3)
	public void testGetVehicleOnRoadPrice()
	{
		
		Vehicle vehicle=vehicleDao.getVehicleById(102);
		
		assertEquals(78000,vehicle.getOnroadPrice());
		
	}
	
	@Test
	@Order(4)
	public void testGetEmploymentByUserId()
	{
		
		Employment employee=employeeDao.getEmploymentByUserId(1003);
		
		assertEquals(700000,employee.getAnnualSalary());
		
	}
	
	
	@Test
	@Order(5)
	public void testGetEmploymentIdByUserId()
	{
		Employment employee=employeeDao.getEmploymentByUserId(1003);
		
		assertEquals(10003,employee.getEmploymentId());
	}
	
	
	@Test
	@Order(6)
	public void testGetEmployeeSalary()
	{
		
		Employment employee=employeeDao.getEmploymentByUserId(1003);
		
		assertNotEquals(500000, employee.getAnnualSalary());
	}
	
	
	
	@Test
	@Order(7)
	public void testGetFourWheelerList()
	{
		
		List<Vehicle> fourWheelerList=vehicleDao.getFourWheelerVehicles();
		
		assertEquals(40,fourWheelerList.size());
		
	}
	
	@Test
	@Order(8)
	public void testGetThreeWheelerList()
	{
		
		List<Vehicle> threeWheelerList=vehicleDao.getThreeWheelerVehicles();
		
		assertEquals(6,threeWheelerList.size());
		
	}
	
	
	@Test
	@Order(9)
	public void testGetTwoWheelerList()
	{
		
		List<Vehicle> twoWheelerList=vehicleDao.getTwoWheelerVehicles();
		
		assertEquals(30,twoWheelerList.size());
		
	}
	
	
	@Test
	@Order(10)
	public void testGetExistingEmi()
	{
	int existingEmi=emiDao.getEmiByUserId(1003);
		
	assertEquals(39000,existingEmi);
		
	}
		
}
