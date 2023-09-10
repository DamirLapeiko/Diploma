package lapeiko.travel_agency.model.client;

import lombok.Value;

@Value
public class ClientDto {
    String email;
    String lastName;
    String firstName;

    public static ClientDto from(Client client){
        return new ClientDto(
                client.getEmail(),
                client.getLastName(),
                client.getFirstName());
    }
}
