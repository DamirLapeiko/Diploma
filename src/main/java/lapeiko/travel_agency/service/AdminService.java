package lapeiko.travel_agency.service;


import lapeiko.travel_agency.model.admin.AdminSignInDto;
import lapeiko.travel_agency.model.admin.AdminSignUpDto;
import lapeiko.travel_agency.model.security.AccessToken;

public interface AdminService {
    AccessToken signIn(AdminSignInDto dto);

    AccessToken signUp(AdminSignUpDto dto);

}
