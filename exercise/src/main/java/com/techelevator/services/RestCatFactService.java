package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {

		@RequestMapping( path = "https://cat-data.netlify.app/api/facts/random", method = RequestMethod.GET)
		public String getPic() {
			return catCardDao.setfile(text);

		}
		https://cat-data.netlify.app/api/facts/random
		return null;
	}

}
