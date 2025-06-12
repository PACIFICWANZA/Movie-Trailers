package dev.pacific.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private ObjectId id;

    private String body;   // The review content (reviewBody)
    private String imdbId; // The IMDb ID to link the review to a specific movie

    // Constructor to create a review with reviewBody and imdbId
    public Review(String body, String imdbId) {
        this.body = body;
        this.imdbId = imdbId;
    }

    // Constructor that only returns body (no imdbId)
    public Review(String body) {
        this.body = body;
    }
}
