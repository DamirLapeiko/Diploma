package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.model.security.AdminPrincipal;

import java.util.List;

public interface CountryAdminService {

    List<CountryDto> getPageWithAllCountries(int pageNumber, AdminPrincipal principal);
    CountryDto create(CountryDto dto, AdminPrincipal principal);

    CountryDto update(long id, CountryDto dto, AdminPrincipal principal);

    void remove(long id,AdminPrincipal principal);


}
