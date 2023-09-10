package lapeiko.travel_agency.repository.jpa;

import lapeiko.travel_agency.model.review.Review;
import lapeiko.travel_agency.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewJpaRepository extends BaseJpaRepository<Review, Long>
        implements ReviewRepository {


    public ReviewJpaRepository() {
        super(Review.class);
    }

    @Override
    public List<Review> findPageWithTourAndReview(long clientId, int pageSize, int pageNumber) {
                    return entityManager.createQuery("""
                        SELECT review
                        FROM Review review
                          JOIN FETCH review.tour
                          JOIN FETCH review.client
                        WHERE review.client.id = :clientId
                        ORDER BY review.createdAt DESC
                        """, Review.class)
                .setParameter("clientId", clientId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
