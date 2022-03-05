package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    //  GET /api/cards: Provides a list of all Cat Cards in the user's collection.

    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> catCards() {
        return catCardDao.list();
    }

    //  GET /api/cards/{id}: Provides a Cat Card with the given ID.
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.get(id);
    }

    // GET /api/cards: Provides a new, randomly created Cat Card containing information from the cat fact and picture services
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public boolean add(@Valid @RequestBody CatCard catCard) {
        return catCardDao.save(catCard);
    }


    // POST /api/cards: Saves a card to the user's collection.

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public boolean addCard(@RequestBody CatCard catCard) {
        return catCardDao.save(catCard);
    }


    //PUT /api/cards/{id}: Updates a card in the user's collection.

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
    public boolean updateCard(@RequestBody long id) throws CatCardNotFoundException {
        return catCardDao.update(id, catCardDao.get(id));
    }


    //DELETE /api/cards/{id}: Removes a card from the user's collection.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable long id) throws CatCardNotFoundException {
        catCardDao.delete(id);
    }

}


