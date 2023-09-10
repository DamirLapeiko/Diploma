package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.review.ReviewCreateDto;
import lapeiko.travel_agency.model.review.ReviewDto;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.security.ClientPrincipal;
import lapeiko.travel_agency.model.tour.TourShortDto;

import java.util.Optional;


public interface ReviewClientService {

    ReviewDto create(TourShortDto dto, ReviewCreateDto review, ClientPrincipal principal);

    ReviewDto update(TourShortDto dto, long id, ReviewShortDto review, ClientPrincipal principal);
    Optional<TourShortDto> remove(long id, int pageNumber, TourShortDto dto, ReviewShortDto review, ClientPrincipal principal);

}
