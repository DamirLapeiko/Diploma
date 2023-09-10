package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.hotel.HotelCreateDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.security.AdminPrincipal;

import java.util.List;
import java.util.Optional;

public interface HotelAdminService {

    List<HotelDto> getPageWithAllHotels(int pageNumber);

    Optional<HotelDto> getPageWithHotelByFeatures(HotelDto dto);
    HotelDto create(HotelCreateDto dto, AdminPrincipal principal);

    HotelDto update(long id, HotelDto dto, AdminPrincipal principal);

    List<HotelDto> remove(long id, int pageNumber, AdminPrincipal principal);

}
