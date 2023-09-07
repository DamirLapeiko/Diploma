package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.review.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends BaseRepository<Review, Long> {

    Optional<Review> findByReviewAndClient(long reviewId, long clientId);

    List<Review> findPageByReviewWithTour(long reviewId, int pageSize, int pageNumber);

    List<Review> findPageByClientWithTourAndReview(long clientId, int pageSize, int pageNumber);

}
