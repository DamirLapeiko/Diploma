package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.tour.Tour;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends BaseRepository<Tour, Long> {

    List<Tour> getAllTours();

    Optional<Tour> getTourByCountry(String name);

    Optional<Tour> getTourByTourType(String tourType);
}
