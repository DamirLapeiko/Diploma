package lapeiko.travel_agency.model.client;

import lombok.Value;

@Value
public class ClientSignUpDto {
    String email;
    String lastName;
    String firstName;
    String password;
}
