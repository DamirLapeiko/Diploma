package lapeiko.travel_agency.model.tour;

import lapeiko.travel_agency.model.hotel.HotelDto;
import lombok.Value;

@Value
public class TourShortDto {
    long id;
    int date;
    int duration;
    double cost;
    HotelDto hotel;

    public static TourShortDto from(Tour tour) {
        return new TourShortDto(
                tour.getId(),
                tour.getDate(),
                tour.getDuration(),
                tour.getCost(),
                HotelDto.from(tour.getHotel())
        );
    }
}
