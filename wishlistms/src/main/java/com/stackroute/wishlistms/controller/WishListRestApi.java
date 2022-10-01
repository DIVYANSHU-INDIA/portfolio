package com.stackroute.wishlistms.controller;

import com.stackroute.wishlistms.dto.AddToWatchList;
import com.stackroute.wishlistms.dto.WishListCityDeatils;
import com.stackroute.wishlistms.exceptions.articleNotFoundException;
import com.stackroute.wishlistms.service.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller API for wishlist module
 *
 * @author DIVYANSHU KUMAR UPADHYAY
 */
@RequestMapping("/wishlist")
@RestController
public class WishListRestApi {

    @Autowired
    private IWishListService service;

    /**
     * Provides API to handel get request for obtaining List of Cities added in mongo database,
     *
     * @return List<WishListCityDeatils>
     * @throws Exception
     * @PathVariable id String,
     */
    @GetMapping("/list")
    public List<WishListCityDeatils> findAll() throws Exception {

        List<WishListCityDeatils> response = service.listWatchListByUserName();
        return response;
    }

    /**
     * Provides API to handel post request for adding Cities in mongo database,
     *
     * @return WishListCityDeatils
     * @throws Exception
     * @RequestBody requestData AddToWatchList,
     */

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public WishListCityDeatils add(@RequestBody AddToWatchList requestData) throws Exception {
        WishListCityDeatils response = service.addToWishList(requestData);
        return response;
    }

}
