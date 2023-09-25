package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.model.country.Country;
import lapeiko.travel_agency.model.country.CountryCreateDto;
import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.repository.AdminRepository;
import lapeiko.travel_agency.repository.CountryRepository;
import lapeiko.travel_agency.service.CountryAdminService;
import lapeiko.travel_agency.service.exception.BusinessException;
import lapeiko.travel_agency.model.security.AdminPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryAdminServiceImpl implements CountryAdminService {

    public static final int COUNTRY_PAGE_SIZE = 10;

    private final CountryRepository countryRepo;
    private final AdminRepository adminRepo;

    @Override
    @Transactional(readOnly = true)
    public List<CountryDto> getPageWithAllCountries(int pageNumber, AdminPrincipal principal) {
        adminRepo.getReferenceById(principal.getId());
        return countryRepo.getAllCountries(COUNTRY_PAGE_SIZE, pageNumber)
                .stream()
                .map(CountryDto::from)
                .toList();
    }

    @Override
    @Transactional
    public CountryDto create(CountryCreateDto dto, AdminPrincipal principal) {
        adminRepo.getReferenceById(principal.getId());
        Country country = new Country()
                .setName(dto.getName());
        countryRepo.create(country);
        return CountryDto.from(country);
    }

    @Override
    @Transactional
    public CountryDto update(long id, CountryDto dto, AdminPrincipal principal) {
        adminRepo.getReferenceById(principal.getId());
        Country country = countryRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Country is not found"));
        country.setName(dto.getName());
        return CountryDto.from(country);
    }

    @Override
    @Transactional
    public void remove(long id, AdminPrincipal principal) {
        adminRepo.getReferenceById(principal.getId());
        Country country = countryRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Country is not found"));
        countryRepo.remove(country);
    }
}
