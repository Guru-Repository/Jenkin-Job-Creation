package com.qa.orangehrm.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransforamation implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Class testClass, Constructor constructor, Method method)
		{
				annotation.setRetryAnalyzer(RetryLogic.class);		
		}
}
