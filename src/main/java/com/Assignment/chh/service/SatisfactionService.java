package com.Assignment.chh.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 
 * @author naveenkumar300@gmail.com
 *
 */

@Component
public class SatisfactionService  {
	private static final Logger LOGGER = LoggerFactory.getLogger(SatisfactionService.class);

	
	public int getMaxSatisfaction(String fileName) {
		
		LOGGER.info("SatisfactionServiceImpl: start");
	
		int maxSatisfactionValue=0;
		List<Integer>timeTakenList=new ArrayList<Integer>();
		List<Integer>satisfactionList=new ArrayList<Integer>();
		BufferedReader br = null;
	
	    try {
	        String sCurrentLine;
	        ClassLoader classLoader = getClass().getClassLoader();
		    File file = new File(classLoader.getResource(fileName).getFile());
		    br = new BufferedReader(new FileReader(file));
	        int i=0;
	        while ((sCurrentLine = br.readLine()) != null) {
	            String[] arr = sCurrentLine.split(" ");
	           
	            timeTakenList.add(Integer.parseInt(arr[1]));
	            satisfactionList.add(Integer.parseInt(arr[0]));
	            
	            i++;
	        }
	        int totalTime=satisfactionList.get(0);
	        int n=timeTakenList.get(0);
	        satisfactionList.remove(0);
	        timeTakenList.remove(0);
	      
	      maxSatisfactionValue= knapSack(totalTime,timeTakenList,satisfactionList,n );
	        System.out.println("maxSatisfactionValue"+maxSatisfactionValue);

	    } catch (IOException e) {
	    	LOGGER.info("Exception: {}",e);
	    } finally {
	        try {
	            if (br != null)
	            	br.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
		 return maxSatisfactionValue;
	}
	
	
	public int knapSack(int totalTime, List<Integer> timeTakenList, List<Integer> satisfactionList, int n)
    {
		
        int i, j;
        int [][]K = new int[n+1][totalTime+1];
 
	   // Building Knap Sack table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= totalTime; j++)
            {
                if (i==0 || j==0)
                    K[i][j] = 0;
                else if (timeTakenList.get(i-1) <= j)
                    K[i][j] = max(satisfactionList.get(i-1) + K[i-1][j-timeTakenList.get(i-1)],  K[i-1][j]);
                else
                    K[i][j] = K[i-1][j];
            }
        }
 
        return K[n][totalTime];
    }
	
	

	 public int max(int a, int b) 
	    { 
	        return (a > b)? a : b; 
	    }
	
}
