package com;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerExample implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test has started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has failed");
	}
	
}
