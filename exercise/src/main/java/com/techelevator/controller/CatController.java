package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    //GET /api/cards: Provides a list of all Cat Cards in the user's collection.

    @RequestMapping(path = "/cards" , method = RequestMethod.GET)
    public List<catCard> getAll(){

        return catCardDao.list();

    }

    ///POST /api/cards: Saves a card to the user's collection.

//    @ResponseStatus (HttpStatus.CREATED)
//    @RequestMapping(path = "/cards" , method = RequestMethod.POST)
//            public boolean addCard (@RequestBody CatCard catCard)
//    {
//
//        return catCardDao.save(catCard);
//    }




}
