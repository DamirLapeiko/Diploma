package lapeiko.travel_agency.model.review;

import lombok.Value;

@Value
public class ReviewCreateDto {
    long tourId;
    String content;
}
