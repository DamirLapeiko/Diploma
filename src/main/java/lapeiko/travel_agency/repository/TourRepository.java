package lapeiko.travel_agency.repository;

import jakarta.persistence.criteria.Predicate;
import lapeiko.travel_agency.model.tour.Tour;

import java.util.List;

public interface TourRepository extends BaseRepository<Tour, Long> {

    List<Tour> getAllTours(int pageSize, int pageNumber);

    List<Tour> findToursByCountry(String name, int pageSize, int pageNumber);

    List<Tour> findTourWithHotelByFeatures(String features, int pageSize, int pageNumber);

    List<Tour> findTourByTourType(String tourType, int pageSize, int pageNumber);

    List<Tour> findTourByParameters(Predicate[] predicates, int pageSize, int pageNumber);
}
