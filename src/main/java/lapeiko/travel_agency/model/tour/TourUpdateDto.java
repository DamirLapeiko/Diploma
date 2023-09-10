package lapeiko.travel_agency.model.tour;

import lombok.Value;

@Value
public class TourUpdateDto {
    int date;
    int duration;
    double cost;
}
