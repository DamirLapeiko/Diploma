package lapeiko.travel_agency.model.review;

import lapeiko.travel_agency.model.client.ClientDto;
import lombok.Value;

import java.time.Instant;

@Value
public class ReviewShortDto {
    long id;
    ClientDto client;
    String content;
    Instant createdAt;

    public static ReviewShortDto from(Review review) {
        return new ReviewShortDto(
                review.getId(),
                ClientDto.from(review.getClient()),
                review.getContent(),
                review.getCreatedAt());
    }
}
