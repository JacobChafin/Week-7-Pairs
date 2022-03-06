package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
		CatPic catPic = new CatPic();
		catPic.setFile("https://cat-data.netlify.app/images/cat-with-bananas-527x600.jpg");
		return catPic;
	}
//	@RequestMapping(path = "https://cat-data.netlify.app/images/cat-with-bananas-527x600.jpg", method = RequestMethod.GET)
//	public CatPic getPic() {
//		public CatPic getPic() {
//			CatPic catpic = new CatPic();
//			String text = "";
//
//			catpic.setfile(file);
//			return catpic;
//		}
//
//	}
}
