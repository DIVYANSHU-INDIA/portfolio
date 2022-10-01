package com.stackroute.wishlistms.service;

import com.stackroute.wishlistms.dto.AddToWatchList;

import com.stackroute.wishlistms.dto.WishListCityDeatils;
import com.stackroute.wishlistms.exceptions.articleAlreadyExistsException;
import com.stackroute.wishlistms.exceptions.articleNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
public interface IWishListService {

    WishListCityDeatils addToWishList(@Valid AddToWatchList requestData) throws articleAlreadyExistsException;



    List<WishListCityDeatils> listWatchListByUserName() throws articleNotFoundException;


}
