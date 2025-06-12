package dev.pacific.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
//Using a template to talk to DB, by calling Update method on movie class associates review with a movie//
//reviewIds is an empty array, updated and new one is pushed//
//movie being updated is movie where imdbId in Db matches users'//
//call apply update, create new update definition pushes change in Db, change reviewIds for this movie//
// new review will be pushed into the reviewIds array//
@Service
public class ReviewService {
//reference to review repository//
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }

}
