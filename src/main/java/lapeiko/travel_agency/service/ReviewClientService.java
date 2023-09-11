package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.review.ReviewCreateDto;
import lapeiko.travel_agency.model.review.ReviewDto;
import lapeiko.travel_agency.model.security.ClientPrincipal;


public interface ReviewClientService {

    ReviewDto create(ReviewCreateDto review, ClientPrincipal principal);

    ReviewDto update(long id, ReviewDto review, ClientPrincipal principal);

    void remove(long id, ClientPrincipal principal);

}
