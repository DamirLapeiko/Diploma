package lapeiko.travel_agency.repository.jpa;

import lapeiko.travel_agency.model.review.Review;
import lapeiko.travel_agency.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ReviewJpaRepository extends BaseJpaRepository<Review, Long>
        implements ReviewRepository {


    public ReviewJpaRepository() {
        super(Review.class);
    }

    @Override
    public Optional<Review> findByReviewAndClient(long reviewId, long clientId) {
        return entityManager.createQuery("""
                        SELECT review
                        FROM Review review
                        WHERE review.id = :reviewId
                          AND review.client.id = :clientId
                        """, Review.class)
                .setParameter("reviewId", reviewId)
                .setParameter("clientId", clientId)
                .getResultStream()
                .findFirst();
    }

    @Override
    public List<Review> findPageByReviewWithTour(long reviewId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT review
                        FROM Review review
                          JOIN FETCH review.client
                          JOIN FETCH review.tour
                        WHERE review.id = :reviewId
                        ORDER BY review.createdAt DESC
                        """, Review.class)
                .setParameter("reviewId", reviewId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Review> findPageByClientWithTourAndReview(long clientId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT review
                        FROM Review review
                          JOIN FETCH review.client
                          JOIN FETCH review.tour
                        WHERE review.client.id = :accountId
                        ORDER BY review.createdAt DESC
                        """, Review.class)
                .setParameter("clientId", clientId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
