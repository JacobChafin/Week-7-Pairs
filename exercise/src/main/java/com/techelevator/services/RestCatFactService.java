package com.techelevator.services;

import com.techelevator.dao.CatCardDao;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {
		CatFact catfact = new CatFact();
		catfact.setText("https://cat-data.netlify.app/api/facts/random");
		return catfact;
	}

//	@RequestMapping(path = "https://cat-data.netlify.app/api/facts/random", method = RequestMethod.GET)
//	public CatFact getFact() {
//		CatFact catfact = new CatFact();
//		String text = "";
//
//		catfact.setText(text);
//			return catfact;
//	}
}
