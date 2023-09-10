package lapeiko.travel_agency.service.impl;

import jakarta.transaction.Transactional;
import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.hotel.HotelFeatures;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.repository.HotelRepository;
import lapeiko.travel_agency.repository.ReviewRepository;
import lapeiko.travel_agency.repository.TourRepository;
import lapeiko.travel_agency.service.TourClientService;
import lapeiko.travel_agency.service.util.TourSearchParameter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    @Transactional
    public List<TourShortDto> getPageWithAllTours(int pageNumber) {
        return tourRepo.getAllTours(TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    public List<HotelDto> getPageWithAllHotels(int pageNumber) {
        return hotelRepo.getAllHotels(HOTEL_PAGE_SIZE, pageNumber)
                .stream()
                .map(HotelDto::from)
                .toList();
    }

    @Override
    @Transactional
    public Optional<TourShortDto> getTourById(long id) {
        return tourRepo.findById(id)
                .stream()
                .map(TourShortDto::from)
                .findFirst();
    }

    @Override
    @Transactional
    public List<TourShortDto> getPageWithToursByCountry(CountryDto dto, int pageNumber) {
        return tourRepo.findToursByCountry(dto.getName(), TOURS_PAGE_SIZE, pageNumber)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    @Transactional
    public Optional<TourShortDto> getPageWithTourAndHotelByFeatures(HotelDto dto) {
        return tourRepo.findTourWithHotelByFeatures(HotelFeatures.valueOf(dto.getHotelFeatures()))
                .stream()
                .map(TourShortDto::from)
                .findFirst();
    }

    @Override
    @Transactional
    public Optional<TourShortDto> getPageWithTourByTourType(TourDto dto) {
        return tourRepo.findTourByTourType(dto.getTourType().getValue())
                .stream()
                .map(TourShortDto::from)
                .findFirst();
    }

    @Override
    @Transactional
    public List<TourShortDto> getToursByParameters(TourSearchParameter[] parameters, int pageSize) {
        return tourRepo.getAllTours(TOURS_PAGE_SIZE, pageSize)
                .stream()
                .map(TourShortDto::from)
                .toList();
    }

    @Override
    @Transactional
    public Optional<TourShortDto> getPageWithReviewsOnTour(ReviewShortDto dto, int pageNumber) {
        return reviewRepo.findPageWithTourAndReview(dto.getId(), REVIEWS_PAGE_SIZE, pageNumber)
                .stream()
                .map(review -> TourShortDto.from(review.getTour()))
                .findFirst();
    }
}
