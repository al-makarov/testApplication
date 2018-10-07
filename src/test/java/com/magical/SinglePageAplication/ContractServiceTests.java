package com.magical.SinglePageAplication;

import com.magical.SinglePageAplication.service.ContractService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractServiceTests {
	private ContractService contractService;
	@Before
	public void initTest() {
		contractService = new ContractService();
	}

	@After
	public void afterTest() {
		contractService = null;
	}

	@Test
	public void testConfirmMinSum() throws Exception {
		assertEquals(true, contractService.confirmMinSum(1200));
		assertEquals(false,contractService.confirmMinSum(1000));
		assertEquals(false, contractService.confirmMinSum(900));
	}

	@Test
	public void testCalcSumWithoutVAT() throws Exception {
			assertEquals(1500, contractService.calcSumWithoutVAT(150,1650),0.05);
	}

	@Test
	public void testCalcRateVAT() throws Exception {
		assertEquals(9, contractService.calcRateVAT(1650,150));
	}



}
