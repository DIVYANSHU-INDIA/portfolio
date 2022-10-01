package com.stackroute.wishlistms.util;

import com.stackroute.wishlistms.dto.AddToWatchList;
import com.stackroute.wishlistms.dto.WishListCityDeatils;



import com.stackroute.wishlistms.entity.article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * utility class for wishlist module
 *
 * @author Govind
 */
@Component
public class WishlistCityUtil {
    /**
     * convert object of type CityInfo i.e, object of entity class to Object of type WishListCityDeatils,
     *
     * @param article article,
     * @return WishListCityDeatils
     */
    public WishListCityDeatils toCityDetails(article article) {
        WishListCityDeatils desired = new WishListCityDeatils();
        desired.setAuthorName(article.getAuthorName());
        desired.setArticleHeading(article.getArticleHeading());
        desired.setArticleContent(article.getArticleContent());
        desired.setDate(article.getDate());
        return desired;
    }

    /**
     * convert object of type AddToWatchList i.e, object of a dto class to Object of type CityInfo,
     *
     * @param article AddToWatchList,
     * @return CityInfo
     */
    public article toCityInfo(AddToWatchList article) {
        article desired = new article();
        desired.setAuthorName(article.getAuthorName());
        desired.setArticleHeading(article.getArticleHeading());
        desired.setArticleContent(article.getArticleContent());
        desired.setDate(article.getDate());

        return desired;
    }

    /**
     * convert Collection<CityInfo> cityInfos  to List<WishListCityDeatils>,
     *
     * @param cityInfos Collection<CityInfo>,
     * @return List<WishListCityDeatils>
     */

    public List<WishListCityDeatils> toListCityDetails(Collection<article> cityInfos) {
        List<WishListCityDeatils> desired = new ArrayList<>();
        for (article city : cityInfos) {
            WishListCityDeatils details = toCityDetails(city);
            desired.add(details);
        }
        return desired;

    }
}
