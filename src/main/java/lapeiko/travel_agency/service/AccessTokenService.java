package lapeiko.travel_agency.service;


import lapeiko.travel_agency.model.security.AccessToken;
import lapeiko.travel_agency.model.security.AccountPrincipal;

public interface AccessTokenService {

    AccessToken generate(AccountPrincipal principal);

    AccountPrincipal authenticate(String accessTokenValue);
}
