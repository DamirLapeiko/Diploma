package lapeiko.travel_agency.model.tour;

import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lombok.Value;

import java.time.LocalDate;

@Value
public class TourDto {
    long id;
    LocalDate date;
    int duration;
    double cost;
    TourType tourType;
    HotelDto hotel;
    CountryDto country;
    public static TourDto from(Tour tour) {
        return new TourDto(
                tour.getId(),
                tour.getDate(),
                tour.getDuration(),
                tour.getCost(),
                tour.getTourType(),
                HotelDto.from(tour.getHotel()),
                CountryDto.from(tour.getCountry())
        );
    }
}
