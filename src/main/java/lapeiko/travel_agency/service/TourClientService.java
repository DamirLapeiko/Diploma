package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.service.util.TourSearchParameter;

import java.util.List;
import java.util.Optional;

public interface TourClientService {

    List<TourShortDto> getPageWithAllTours(int pageNumber);

    List<HotelDto> getPageWithAllHotels(int pageNumber);

    Optional<TourShortDto> getTourById(long id);

    List<TourShortDto> getPageWithToursByCountry(CountryDto dto, int pageNumber);

    Optional<TourShortDto> getPageWithTourAndHotelByFeatures(HotelDto dto);

    Optional<TourShortDto> getPageWithTourByTourType(TourDto dto);

    List<TourShortDto> getToursByParameters(TourSearchParameter[] parameters, int pageNumber);

    Optional<TourShortDto> getPageWithReviewsOnTour(ReviewShortDto dto, int pageNumber);

}
