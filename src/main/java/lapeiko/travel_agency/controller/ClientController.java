package lapeiko.travel_agency.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lapeiko.travel_agency.model.review.ReviewCreateDto;
import lapeiko.travel_agency.model.review.ReviewDto;
import lapeiko.travel_agency.service.ReviewClientService;
import lapeiko.travel_agency.model.security.ClientPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-api")
@RequiredArgsConstructor
@Tag(name = "Client API", description = "Endpoints that require client authentication")
public class ClientController {

    private final ReviewClientService reviewService;

    @PostMapping("/tour-reviews")
    public ReviewDto createReview(
            @RequestBody ReviewCreateDto reviewDto,
            @AuthenticationPrincipal ClientPrincipal principal
    ) {
        return reviewService.create(reviewDto, principal);
    }

    @PutMapping("/tour-reviews/updateReview/{reviewId}")
    public ReviewDto updateReview(
            @PathVariable long reviewId,
            @RequestBody ReviewDto dto,
            @AuthenticationPrincipal ClientPrincipal principal
    ) {
        return reviewService.update(reviewId, dto, principal);
    }

    @PostMapping("/tour-reviews/removeReview/{reviewId}")
    public void removeReview(
            @PathVariable long reviewId,
            @AuthenticationPrincipal ClientPrincipal principal
    ) {
        reviewService.remove(reviewId, principal);
    }
}
