package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.model.client.Client;
import lapeiko.travel_agency.model.review.Review;
import lapeiko.travel_agency.model.review.ReviewCreateDto;
import lapeiko.travel_agency.model.review.ReviewDto;
import lapeiko.travel_agency.model.tour.Tour;
import lapeiko.travel_agency.repository.ClientRepository;
import lapeiko.travel_agency.repository.ReviewRepository;
import lapeiko.travel_agency.repository.TourRepository;
import lapeiko.travel_agency.service.TourClientService;
import lapeiko.travel_agency.service.exception.BusinessException;
import lapeiko.travel_agency.model.security.ClientPrincipal;
import lapeiko.travel_agency.service.ReviewClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ReviewClientServiceImpl implements ReviewClientService {

    private final ReviewRepository reviewRepo;
    private final ClientRepository clientRepo;
    private final TourRepository tourRepo;
    private final TourClientService tourClientService;

    @Override
    @Transactional
    public ReviewDto create(ReviewCreateDto review, ClientPrincipal principal) {
        Tour tour = tourRepo.findById(review.getTourId())
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
    @Transactional
    public ReviewDto update(long id, ReviewDto review, ClientPrincipal principal) {
        tourRepo.findById(review.getTour().getId())
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
    @Transactional
    public void remove(long id, ClientPrincipal principal) {
        Review deletedReview = reviewRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Review is not found"));
        clientRepo.getReferenceById(principal.getId());
        reviewRepo.remove(deletedReview);
    }
}
