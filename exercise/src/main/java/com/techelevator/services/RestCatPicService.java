package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
	private final RestTemplate restTemplate = new RestTemplate();
	@Override
	public CatPic getPic() {
		CatPic catPic = null;
		catPic = restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
		return catPic;
	}
}
