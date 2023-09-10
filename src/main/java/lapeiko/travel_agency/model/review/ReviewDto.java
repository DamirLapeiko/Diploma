package lapeiko.travel_agency.model.review;

import lapeiko.travel_agency.model.client.ClientDto;
import lapeiko.travel_agency.model.tour.TourDto;
import lombok.Value;

import java.time.Instant;

@Value
public class ReviewDto {
    long id;
    ClientDto client;
    TourDto tour;
    String content;
    Instant createdAt;

    public static ReviewDto from(Review review) {
        return new ReviewDto(
                review.getId(),
                ClientDto.from(review.getClient()),
                TourDto.from(review.getTour()),
                review.getContent(),
                review.getCreatedAt()
        );
    }
}
