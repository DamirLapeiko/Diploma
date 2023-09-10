package lapeiko.travel_agency.model.hotel;

import lombok.Value;

@Value
public class HotelDto {
    long id;
    String name;
    int stars;
    String hotelFeatures;

    public static HotelDto from(Hotel hotel){
        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getStars(),
                hotel.getFeatures().getValue()
        );
    }
}
