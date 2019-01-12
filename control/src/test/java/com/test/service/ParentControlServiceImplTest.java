package com.test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.test.Exception.TitleNotFounException;
import com.test.model.ParentalLevelEnum;
import com.test.service.impl.ParentalControlServiceImpl;

public class ParentControlServiceImplTest {
	
	@Mock
	private  MovieService mockMovieService;
	
	private  ParentalControlServiceImpl target;
	
	
	@BeforeClass
	public static void setUpTestClass() {
		
		
				
	}
	
	@Before
	public void setUptest() {
		
		mockMovieService = Mockito.mock(MovieService.class);
		
		
		target = new ParentalControlServiceImpl();
		target.setMovieService(mockMovieService);
	}
	
	
	@Test
	public void test_userWithTheCorrectParentControl_True() throws Exception  {
		
		String titleId   = "PGratingMovie";
		
		when(mockMovieService.getParentalControlLevel(titleId)).thenReturn(ParentalLevelEnum.U.name());
		
		assertTrue(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.U));
		assertTrue(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.PG));		
		assertTrue(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.TWELVE));
		assertTrue(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.FIFTEEN));
		assertTrue(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.EIGHTEEN));
		
		
		
		
	}
	
	
	@Test
	public void test_userWithWrongParentalControl_False() throws Exception {
		
		
			
		String titleId   = "18RatingTitle";
		
		
		when(mockMovieService.getParentalControlLevel(titleId)).thenReturn(ParentalLevelEnum.EIGHTEEN.name());
		
		assertFalse(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.PG));
		assertFalse(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.U));
		assertFalse(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.TWELVE));
		assertFalse(target.isClientAllowedToAccess(titleId, ParentalLevelEnum.FIFTEEN));
		
		
				
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(expected=TitleNotFounException.class)	
	public void test_invalidMovie_throws_MovieNotFoundException() throws Exception {
		
		
		ParentalLevelEnum inputParentalControl = ParentalLevelEnum.U;	
		String titleId   = "UparentControlNotpermitedTitle";
		
		when(mockMovieService.getParentalControlLevel(titleId)).thenThrow(TitleNotFounException.class);
		
		boolean result = target.isClientAllowedToAccess(titleId, inputParentalControl);
		
	}
	

	
	
	
	

}
