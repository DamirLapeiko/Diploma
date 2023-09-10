package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.client.ClientSignInDto;
import lapeiko.travel_agency.model.client.ClientSignUpDto;
import lapeiko.travel_agency.model.security.AccessToken;

public interface ClientService {
    AccessToken signIn(ClientSignInDto dto);

    AccessToken signUp(ClientSignUpDto dto);
}
