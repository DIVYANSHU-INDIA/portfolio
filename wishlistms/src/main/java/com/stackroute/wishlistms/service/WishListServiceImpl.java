package com.stackroute.wishlistms.service;

import com.stackroute.wishlistms.entity.article;
import com.stackroute.wishlistms.exceptions.articleAlreadyExistsException;
import com.stackroute.wishlistms.exceptions.articleNotFoundException;
import com.stackroute.wishlistms.repository.IArticleRepository;

import com.stackroute.wishlistms.dto.AddToWatchList;

import com.stackroute.wishlistms.dto.WishListCityDeatils;
import com.stackroute.wishlistms.util.WishlistCityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * service implementation for wishlist module
 *
 * @author DIVYANSHU KUMAR UPADHYAY
 */
@Service
public class WishListServiceImpl implements IWishListService {

    @Autowired
    private IArticleRepository repository;
    @Autowired
    private WishlistCityUtil util;


    public String generateId(String authorName, String articleHeading) {
        String id = authorName + "-" + articleHeading ;
        return id;
    }

    /**
     * saves wislisted city in the mongo database,
     * if city already exists for the given username, city, state and country then throw articleAlreadyExistsException
     *
     * @param requestData AddToWatchList
     * @return WishListCityDeatils
     * @throws articleAlreadyExistsException if city already exists
     */
    @Override
    public WishListCityDeatils addToWishList(AddToWatchList requestData) throws articleAlreadyExistsException {
        Optional<article> optional = repository.findByAuthorNameAndArticleHeading(requestData.getAuthorName(), requestData.getArticleHeading());
        if (optional.isPresent()) {
            throw new articleAlreadyExistsException("City Info is already present in the WishList!");

        }
        article article = new article();

        article.setId(generateId(requestData.getAuthorName(), requestData.getArticleHeading()));
        article.setAuthorName(requestData.getAuthorName());
        article.setArticleHeading(requestData.getArticleHeading());
        article.setArticleContent(requestData.getArticleContent());
        article.setDate(requestData.getDate());

        article = repository.save(article);

        WishListCityDeatils desired = util.toCityDetails(article);
        return desired;
    }



    /**
     * Return listed cities from the mongo database,
     * if list doesn't exist for the given username then throw articleNotFoundException
     *
     * @return void
     * @throws articleNotFoundException if city list doesn't exist
     */
    @Override
    public List<WishListCityDeatils> listWatchListByUserName() throws articleNotFoundException {
        List<article> articleList = repository.findAll();
        if (articleList.isEmpty()) {
            throw new articleNotFoundException("No City Found!");
        }
        List<WishListCityDeatils> desired = util.toListCityDetails(articleList);
        return desired;
    }
}

