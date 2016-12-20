package Testcases;
import static org.junit.Assert.*;

import org.junit.Test;

import com.Assignment.chh.service.SatisfactionService;

public class TestingSatisfactionService{
	
	/*
	 * Test method for success
	 */
	@Test
	public void testSatisfactionServiceSuccess() {
		final String fileName="data.txt";
		int maxSatisfactionValueexpected=2493893;
		SatisfactionService satisfactionServiceImpl=new SatisfactionService();
		
		int maxSatisfactionValuetest= satisfactionServiceImpl.getMaxSatisfaction(fileName);
		
		assertEquals(maxSatisfactionValueexpected,maxSatisfactionValuetest);

     }
	
	
	/*
	 * Test method for FileNotFoundException
	 */

	@Test(expected = java.io.IOException.class)
	public void testFilenotFoundSatisfactionService() {
		final String fileName="";
		SatisfactionService satisfactionServiceImpl=new SatisfactionService();
		
		satisfactionServiceImpl.getMaxSatisfaction(fileName);
		
	

     }
	
	
	
}