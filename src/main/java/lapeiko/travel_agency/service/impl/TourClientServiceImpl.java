package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.repository.TourRepository;
import lapeiko.travel_agency.service.util.TourSearchParameter;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.repository.HotelRepository;
import lapeiko.travel_agency.repository.ReviewRepository;
import lapeiko.travel_agency.service.TourClientService;
import lapeiko.travel_agency.service.exception.NoSearchParameterException;
import lapeiko.travel_agency.service.util.PredicateBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourClientServiceImpl implements TourClientService {

    public static final int TOURS_PAGE_SIZE = 10;
    public static final int REVIEWS_PAGE_SIZE = 5;
    public static final int HOTEL_PAGE_SIZE = 10;

    private final TourRepository tourRepo;
    private final HotelRepository hotelRepo;
    private final ReviewRepository reviewRepo;

    @Override
    @Transactional(readOnly = true)
    public List<TourShortDto> getPageWithAllTours(int pageNumber) {
        return tourRepo.getAllTours(TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HotelDto> getPageWithAllHotels(int pageNumber) {
        return hotelRepo.getAllHotels(HOTEL_PAGE_SIZE, pageNumber)
                .stream()
                .map(HotelDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TourShortDto> getTourById(long id) {
        return tourRepo.findById(id)
                .stream()
                .map(TourShortDto::from)
                .findFirst();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TourShortDto> getPageWithToursByCountry(String countryQuery, int pageNumber) {
        String dbCountryQuery = "%" + countryQuery + "%";
        return tourRepo.findToursByCountry(dbCountryQuery, TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TourShortDto> getPageWithTourAndHotelByFeatures(String hotelFeatures, int pageNumber) {
        return tourRepo.findTourWithHotelByFeatures(hotelFeatures, TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TourDto> getPageWithTourByTourType(String tourType, int pageNumber) {
        return tourRepo.findTourByTourType(tourType, TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourDto::from)
                .toList();
    }

    @Override
    @Transactional
    public List<TourShortDto> getToursByParameters(TourSearchParameter[] parameters, int pageNumber) throws NoSearchParameterException {
        return tourRepo.findTourByParameters(PredicateBuilder.buildPredicate(parameters), TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    @Transactional
    public List<TourShortDto> getPageWithReviewsOnTour(ReviewShortDto dto, int pageNumber) {
        return reviewRepo.findPageWithTourAndReview(dto.getId(), REVIEWS_PAGE_SIZE, pageNumber)
                .stream()
                .map(review -> TourShortDto.from(review.getTour()))
                .toList();
    }
}
