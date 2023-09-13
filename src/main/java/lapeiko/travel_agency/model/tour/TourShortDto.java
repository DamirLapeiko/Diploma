package lapeiko.travel_agency.model.tour;

import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lombok.Value;

import java.time.LocalDate;

@Value
public class TourShortDto {
    long id;
    LocalDate date;
    int duration;
    double cost;
    HotelDto hotel;
    CountryDto country;

    public static TourShortDto from(Tour tour) {
        return new TourShortDto(
                tour.getId(),
                tour.getDate(),
                tour.getDuration(),
                tour.getCost(),
                HotelDto.from(tour.getHotel()),
                CountryDto.from(tour.getCountry())
        );
    }
}
