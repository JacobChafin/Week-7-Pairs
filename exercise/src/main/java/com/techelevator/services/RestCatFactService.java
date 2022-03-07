package com.techelevator.services;

import com.techelevator.dao.CatCardDao;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public CatFact getFact() {
        CatFact catFact = null;
        catFact = restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
        return catFact;
    }

}
