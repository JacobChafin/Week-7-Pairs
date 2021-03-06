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

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    // GET /api/cards: Provides a new, randomly created Cat Card containing information from the cat fact and picture services
    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard generateRandomCatCard() {
        CatCard catCard = new CatCard();
        catCard.setCatFact(catFactService.getFact().getText());
        catCard.setImgUrl(catPicService.getPic().getFile());
        return catCard;
    }

    //  GET /api/cards: Provides a list of all Cat Cards in the user's collection.
    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> listAllCatCards() {
        return catCardDao.list();
    }

    //  GET /api/cards/{id}: Provides a Cat Card with the given ID.
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id) {
        return catCardDao.get(id);
    }

    // POST /api/cards: Saves a card to the user's collection.
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public void addCard(@Valid @RequestBody CatCard catCard) {
        catCardDao.save(catCard);
    }

    //PUT /api/cards/{id}: Updates a card in the user's collection.

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
    public void updateCard(@Valid @RequestBody CatCard changedCard, @PathVariable long id) throws CatCardNotFoundException {
        catCardDao.update(id, changedCard);
    }

    //DELETE /api/cards/{id}: Removes a card from the user's collection.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) throws CatCardNotFoundException{
        catCardDao.delete(id);
    }

}


