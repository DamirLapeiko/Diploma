package lapeiko.travel_agency.model.client;

import lombok.Value;

@Value
public class ClientSignInDto {
    String email;
    String lastName;
    String firstName;
    String password;
}
