package com.stackroute.wishlistms.repository;

import java.util.List;

import com.stackroute.wishlistms.entity.article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IArticleRepository extends MongoRepository<article, String> {


    Optional<article> findByAuthorNameAndArticleHeading(String authorName, String articleHeading);
}
