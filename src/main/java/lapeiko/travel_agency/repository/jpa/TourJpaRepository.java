package lapeiko.travel_agency.repository.jpa;

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
    public List<Tour> getAllTours() {
        return entityManager.createQuery("""
                        SELECT tour
                        FROM Tour tour
                        """, Tour.class)
                .getResultList();
    }

    @Override
    public Optional<Tour> getTourByCountry(String name) {
        return entityManager.createQuery("""
                        SELECT tour
                        FROM Tour tour
                        WHERE tour.country.name = country.name
                        """, Tour.class)
                .setParameter("name", name)
                .getResultStream().findFirst();
    }

    @Override
    public Optional<Tour> getTourByTourType(String tourType) {
        return entityManager.createQuery("""
                        SELECT tour
                        FROM Tour tour
                        WHERE tour.tourType = tourType
                        """, Tour.class)
                .setParameter("tourType", tourType)
                .getResultStream().findFirst();
    }
}
