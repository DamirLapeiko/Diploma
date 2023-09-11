package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.model.hotel.Hotel;
import lapeiko.travel_agency.model.hotel.HotelCreateDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.repository.AdminRepository;
import lapeiko.travel_agency.service.exception.BusinessException;
import lapeiko.travel_agency.model.hotel.HotelFeatures;
import lapeiko.travel_agency.model.security.AdminPrincipal;
import lapeiko.travel_agency.repository.HotelRepository;
import lapeiko.travel_agency.service.HotelAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelAdminServiceImpl implements HotelAdminService {

    public static final int HOTEL_PAGE_SIZE = 10;

    private final HotelRepository hotelRepo;
    private final AdminRepository adminRepo;

    @Override
    @Transactional(readOnly = true)
    public List<HotelDto> getPageWithAllHotels(int pageNumber) {
        return hotelRepo.getAllHotels(HOTEL_PAGE_SIZE, pageNumber)
                .stream()
                .map(HotelDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HotelDto> getPageWithHotelByFeatures(HotelDto dto) {
        return hotelRepo.getHotelByFeatures(dto.getHotelFeatures())
                .stream()
                .map(HotelDto::from)
                .findFirst();
    }

    @Override
    @Transactional
    public HotelDto create(HotelCreateDto dto, AdminPrincipal principal) {
        adminRepo.getReferenceById(principal.getId());
        Hotel hotel = new Hotel()
                .setName(dto.getName())
                .setStars(dto.getStars())
                .setFeatures(HotelFeatures.valueOf(dto.getHotelFeatures()));
        hotelRepo.create(hotel);
        return HotelDto.from(hotel);
    }

    @Override
    @Transactional
    public HotelDto update(long id, HotelDto dto, AdminPrincipal principal) {
        Hotel hotel = hotelRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Hotel is not found"));
        validateAccess(hotel, principal);
        hotel.setName(dto.getName());
        hotel.setStars(dto.getStars());
        hotel.setFeatures(HotelFeatures.valueOf(dto.getHotelFeatures()));
        return HotelDto.from(hotel);
    }

    @Override
    @Transactional
    public void remove(long id, AdminPrincipal principal) {
        Hotel hotel = hotelRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Hotel is not found"));
        validateAccess(hotel, principal);
        hotelRepo.remove(hotel);
    }

    private void validateAccess(Hotel hotel, AdminPrincipal principal) {
        long authenticatedId = principal.getId();
        long ownerId = hotel.getAdmin().getId();
        if (authenticatedId != ownerId) {
            throw new BusinessException("Access denied");
        }
    }
}