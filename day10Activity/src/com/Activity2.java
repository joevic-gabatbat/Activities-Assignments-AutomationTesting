package com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity2 {
//  @Test(dataProvider="getDataSet")
  @Test(dataProvider="DataSet2")
  public void testAddition(int actual, int expected) {
	  int actualValue=actual+20;
	  Assert.assertEquals(actualValue, expected);
  }
  
  @DataProvider
  public Object[][] getDataSet(){
	  return new Object[][] {
		  {40, 60},
		  {120, 140}
	  };
  }
  
  @DataProvider(name="DataSet2")
  public Object[][] getDataSet2(){
	  return new Object[][] {
		  {50, 70},
		  {120, 150}
	  };
  }
}
