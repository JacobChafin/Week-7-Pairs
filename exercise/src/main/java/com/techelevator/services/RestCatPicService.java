package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
//		@RequestMapping( path = "https://cat-data.netlify.app/images/cat-with-bananas-527x600.jpg", method = RequestMethod.GET)
//				public String getPic() {
//			return catCardDao.setfile(file);
//		}

		return null;
	}

}	
