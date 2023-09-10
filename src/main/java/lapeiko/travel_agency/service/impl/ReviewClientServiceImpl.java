package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.model.client.Client;
import lapeiko.travel_agency.model.review.Review;
import lapeiko.travel_agency.model.review.ReviewCreateDto;
import lapeiko.travel_agency.model.review.ReviewDto;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.security.ClientPrincipal;
import lapeiko.travel_agency.model.tour.Tour;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.repository.ClientRepository;
import lapeiko.travel_agency.repository.ReviewRepository;
import lapeiko.travel_agency.repository.TourRepository;
import lapeiko.travel_agency.service.ReviewClientService;
import lapeiko.travel_agency.service.TourClientService;
import lapeiko.travel_agency.service.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewClientServiceImpl implements ReviewClientService {

    private final ReviewRepository reviewRepo;
    private final ClientRepository clientRepo;
    private final TourRepository tourRepo;
    private final TourClientService tourClientService;

    @Override
    public ReviewDto create(TourShortDto dto, ReviewCreateDto review, ClientPrincipal principal) {
        Tour tour = tourRepo.findById(dto.getId())
                .orElseThrow(() -> new BusinessException("Tour is not found"));
        Client client = clientRepo.getReferenceById(principal.getId());
        Instant createdAt = Instant.now();
        Review newReview = new Review()
                .setClient(client)
                .setTour(tour)
                .setContent(review.getContent())
                .setCreatedAt(createdAt);
        reviewRepo.create(newReview);
        return ReviewDto.from(newReview);
    }

    @Override
    public ReviewDto update(TourShortDto dto, long id, ReviewShortDto review, ClientPrincipal principal) {
        tourRepo.findById(dto.getId())
                .orElseThrow(() -> new BusinessException("Tour is not found"));
        reviewRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Review is not found"));
        clientRepo.getReferenceById(principal.getId());
        Instant createdAt = Instant.now();
        Review updateReview = new Review()
                .setContent(review.getContent())
                .setCreatedAt(createdAt);
        reviewRepo.update(updateReview);
        return ReviewDto.from(updateReview);
    }

    @Override
    public Optional<TourShortDto> remove(long id, int pageNumber, TourShortDto dto, ReviewShortDto review, ClientPrincipal principal) {
        tourRepo.findById(dto.getId())
                .orElseThrow(() -> new BusinessException("Tour is not found"));
        Review deletedReview = reviewRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Review is not found"));
        clientRepo.getReferenceById(principal.getId());
        reviewRepo.remove(deletedReview);
        return tourClientService.getPageWithReviewsOnTour(review, pageNumber);
    }
}
