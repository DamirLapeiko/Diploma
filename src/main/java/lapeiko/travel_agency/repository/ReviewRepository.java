package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.review.Review;

import java.util.List;

public interface ReviewRepository extends BaseRepository<Review, Long> {

    List<Review> findPageWithTourAndReview(long clientId, int pageSize, int pageNumber);

}
