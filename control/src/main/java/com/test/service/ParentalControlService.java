package com.test.service;

import com.test.Exception.MovieRatingNotRecognizedException;
import com.test.Exception.TechnicalFailureException;
import com.test.Exception.TitleNotFounException;
import com.test.model.ParentalLevelEnum;

public interface ParentalControlService {
	
	//parentalControl need to change for enum
	public boolean isClientAllowedToAccess(String titleId, ParentalLevelEnum parentalControl) throws TitleNotFounException, TechnicalFailureException, MovieRatingNotRecognizedException;

}
