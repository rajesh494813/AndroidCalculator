package mobiletests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AndroidCalculator;

public class SanityTest extends BaseTest {

	public AndroidCalculator androidCalculator;

	public SanityTest() {

	}
    
	//To test the addition functionality with data provider
	@Test(priority=1,dataProvider="InputData")
	public void additionTest(String s1,String s2) {

		androidCalculator = new AndroidCalculator(driver);

		androidCalculator.inputLeftAndRightFields(s1,s2);
		androidCalculator.addition();

		Assert.assertEquals(androidCalculator.verifyResult(), Integer.parseInt(s1)+Integer.parseInt(s2));
	}
    
	//To test the subtraction functionality without data provider
	@Test(priority=2)

	public void subtractionTest() {

		androidCalculator = new AndroidCalculator(driver);

		androidCalculator.inputLeftAndRightFields("20", "10");
		androidCalculator.subtraction();

		Assert.assertEquals(androidCalculator.verifyResult(), 20+10);
	}
    
	//To test the multiplication functionality without data provider
	
	@Test(priority=3)

	public void multiplicationTest() {

		androidCalculator = new AndroidCalculator(driver);

		androidCalculator.inputLeftAndRightFields("20", "10");
		androidCalculator.multiplication();;

		Assert.assertEquals(androidCalculator.verifyResult(), 20*10);
	}
	
	//To test the division functionality without data provider
	@Test(priority=4)

	public void divisionTest() {

		androidCalculator = new AndroidCalculator(driver);

		androidCalculator.inputLeftAndRightFields("20", "10");
		androidCalculator.division();

		Assert.assertEquals(androidCalculator.verifyResult(), 20/10);
	}
	
	//The method provides testdata for Addition Test
	@DataProvider(name = "InputData")
	 
	  public static Object[][] inputData() {
	 
	        return new Object[][] { { "20","20" }, { "10","10" }};
	 
	  }
	
	
	        }
	

