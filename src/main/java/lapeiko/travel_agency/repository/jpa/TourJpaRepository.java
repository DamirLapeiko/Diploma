package lapeiko.travel_agency.repository.jpa;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lapeiko.travel_agency.model.hotel.HotelFeatures;
import lapeiko.travel_agency.model.tour.Tour;
import lapeiko.travel_agency.model.tour.TourType;
import lapeiko.travel_agency.repository.TourRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourJpaRepository extends BaseJpaRepository<Tour, Long>
        implements TourRepository {
    public TourJpaRepository() {
        super(Tour.class);
    }

    @Override
    public List<Tour> getAllTours(int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT tour
                        FROM Tour tour
                        """, Tour.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Tour> findToursByCountry(String countryQuery, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT tour
                        From Tour tour
                        JOIN FETCH tour.country
                        WHERE tour.country.name ILIKE :countryQuery 
                        ORDER BY tour.date DESC
                        """, Tour.class)
                .setParameter("countryQuery", countryQuery)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Tour> findTourWithHotelByFeatures(HotelFeatures features, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT tour
                        From Tour tour
                        JOIN FETCH tour.hotel
                        WHERE tour.hotel.features = :features
                        ORDER BY tour.date DESC 
                        """, Tour.class)
                .setParameter("features", features)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Tour> findTourByTourType(TourType tourType, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT tour
                        From Tour tour
                        WHERE tour.tourType = :tourType
                        ORDER BY tour.date DESC 
                        """, Tour.class)
                .setParameter("tourType", tourType)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Tour> findTourByParameters(Predicate[] predicates, int pageSize, int pageNumber) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tour> query = criteriaBuilder.createQuery(Tour.class);
        Root<Tour> tourRoot = query.from(Tour.class);
        query.select(tourRoot).where(predicates);
        return entityManager.createQuery(query)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
