package lapeiko.travel_agency.repository.jpa;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lapeiko.travel_agency.model.hotel.HotelFeatures;
import lapeiko.travel_agency.model.tour.Tour;
import lapeiko.travel_agency.repository.TourRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public List<Tour> findToursByCountry(String name, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT tour
                        From Tour tour
                        WHERE tour.country.name = country.name
                        """, Tour.class)
                .setParameter("name", name)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
    @Override
    public Optional<Tour> findTourWithHotelByFeatures(HotelFeatures features){
        return entityManager.createQuery("""
                        SELECT tour
                        From Tour tour
                        WHERE tour.hotel.features = hotel.features
                        """, Tour.class)
                .setParameter("features", features)
                .getResultStream()
                .findFirst();
    }

    @Override
    public Optional<Tour> findTourByTourType(String tourType) {
        return entityManager.createQuery("""
                        SELECT tour
                        From Tour tour
                        WHERE tour.tourType = tourType
                        """, Tour.class)
                .setParameter("tourType", tourType)
                .getResultStream()
                .findFirst();
    }

    @Override
    public List<Tour> getByParameters(Predicate[] predicates) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tour> query = criteriaBuilder.createQuery(Tour.class);
        Root<Tour> tourRoot = query.from(Tour.class);
        query.select(tourRoot).where(predicates);
        return entityManager.createQuery(query).getResultList();
    }
}
