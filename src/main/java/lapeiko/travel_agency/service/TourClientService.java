package lapeiko.travel_agency.service;

import lapeiko.travel_agency.service.util.TourSearchParameter;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.service.exception.NoSearchParameterException;

import java.util.List;
import java.util.Optional;

public interface TourClientService {

    List<TourShortDto> getPageWithAllTours(int pageNumber);

    List<HotelDto> getPageWithAllHotels(int pageNumber);

    Optional<TourShortDto> getTourById(long id);

    List<TourShortDto> getPageWithToursByCountry(String countryQuery, int pageNumber);

    List<TourShortDto> getPageWithTourAndHotelByFeatures(String hotelFeatures, int pageNumber);

    List<TourDto> getPageWithTourByTourType(String tourType, int pageNumber);

    List<TourShortDto> getToursByParameters(TourSearchParameter[] parameters, int pageNumber) throws NoSearchParameterException;

    List<TourShortDto> getPageWithReviewsOnTour(ReviewShortDto dto, int pageNumber);

}
