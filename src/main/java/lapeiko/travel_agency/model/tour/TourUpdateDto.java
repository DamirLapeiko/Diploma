package lapeiko.travel_agency.model.tour;

import lombok.Value;

import java.time.LocalDate;

@Value
public class TourUpdateDto {
    LocalDate date;
    int duration;
    double cost;
}
