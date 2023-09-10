package lapeiko.travel_agency.model.hotel;

import lombok.Value;

@Value
public class HotelCreateDto {
    String name;
    int stars;
    String hotelFeatures;
}