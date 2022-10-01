package com.stackroute.wishlistms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Response DTO Class for wishlist module
 *
 * @author Gawtham
 */

public class WishListCityDeatils {
    private String authorName;
    @NotBlank
    @Length(min = 2)
    private String articleHeading;
    @NotBlank
    @Length(min = 2)
    private String articleContent;
    @NotBlank
    @Length(min = 2)
    private String date;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getArticleHeading() {
        return articleHeading;
    }

    public void setArticleHeading(String articleHeading) {
        this.articleHeading = articleHeading;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
