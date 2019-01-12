package com.test.service;

import com.test.Exception.TechnicalFailureException;
import com.test.Exception.TitleNotFounException;

public interface MovieService {
	
	String getParentalControlLevel(String movieId)
		throws TitleNotFounException,TechnicalFailureException;

}
