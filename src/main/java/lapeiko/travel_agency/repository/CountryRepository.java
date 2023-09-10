package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.country.Country;

import java.util.List;


public interface CountryRepository extends BaseRepository<Country, Long> {

    List<Country> getAllCountries(int pageSize, int pageNumber);
}
