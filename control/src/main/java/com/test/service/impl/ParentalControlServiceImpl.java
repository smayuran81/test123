package com.test.service.impl;

import java.util.stream.Stream;

import com.test.Exception.MovieRatingNotRecognizedException;
import com.test.Exception.TechnicalFailureException;
import com.test.Exception.TitleNotFounException;
import com.test.model.ParentalLevelEnum;
import com.test.service.MovieService;
import com.test.service.ParentalControlService;

public class ParentalControlServiceImpl implements ParentalControlService {
	
	
	private MovieService movieService;

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		
		this.movieService = movieService;
		
	}

	public ParentalControlServiceImpl() {
				
	}

	public boolean isClientAllowedToAccess(String titleId, ParentalLevelEnum inputParentalControl) throws TitleNotFounException,TechnicalFailureException,MovieRatingNotRecognizedException {

		String movieParentalLevel = this.movieService.getParentalControlLevel(titleId);

		ParentalLevelEnum requiredParentalLevel =  ParentalLevelEnum.valueOf(movieParentalLevel);

		if(!ParentalLevelEnum.isValidParentLevel(requiredParentalLevel)) 
			throw new MovieRatingNotRecognizedException("Movie Rating not recognized");
		
		
		return ParentalLevelEnum.isInputRatingGreaterThanRequiredRating(inputParentalControl,requiredParentalLevel);
								
		
	}

}

