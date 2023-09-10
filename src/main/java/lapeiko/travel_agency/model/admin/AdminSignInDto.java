package lapeiko.travel_agency.model.admin;

import lombok.Value;

@Value
public class AdminSignInDto {
    String email;
    String name;
    String password;
}
