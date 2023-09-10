package lapeiko.travel_agency.model.country;

import lombok.Value;

@Value
public class CountryDto {
    long id;
    String name;

    public static CountryDto from(Country country){
        return new CountryDto(
                country.getId(),
                country.getName());
    }
}
