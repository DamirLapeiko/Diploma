package lapeiko.travel_agency.repository;

import jakarta.persistence.criteria.Predicate;
import lapeiko.travel_agency.model.hotel.HotelFeatures;
import lapeiko.travel_agency.model.tour.Tour;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends BaseRepository<Tour, Long> {

    List<Tour> getAllTours(int pageSize, int pageNumber);

    List<Tour> findToursByCountry(String name, int pageSize, int pageNumber);

    Optional<Tour> findTourWithHotelByFeatures(HotelFeatures features);
    Optional<Tour> findTourByTourType(String tourType);

    List<Tour> getByParameters(Predicate[] predicates);

}
