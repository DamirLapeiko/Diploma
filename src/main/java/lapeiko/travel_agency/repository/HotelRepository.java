package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.hotel.Hotel;

import java.util.List;
import java.util.Optional;


public interface HotelRepository extends BaseRepository<Hotel, Long> {

    List<Hotel> getAllHotels(int pageSize, int pageNumber);

    Optional<Hotel> getHotelByFeatures(String features);
}
