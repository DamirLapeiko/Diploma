package lapeiko.travel_agency.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lapeiko.travel_agency.model.country.CountryCreateDto;
import lapeiko.travel_agency.model.country.CountryDto;
import lapeiko.travel_agency.model.hotel.HotelCreateDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourUpdateDto;
import lapeiko.travel_agency.model.security.AdminPrincipal;
import lapeiko.travel_agency.service.CountryAdminService;
import lapeiko.travel_agency.service.HotelAdminService;
import lapeiko.travel_agency.service.TourAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-api")
@RequiredArgsConstructor
@Tag(name = "Admin API", description = "Endpoints that require admin authentication")
public class AdminController {

    private final TourAdminService tourService;
    private final HotelAdminService hotelService;
    private final CountryAdminService countryService;

    @PostMapping("/tours/createTour")
    public TourDto createTour(
            @RequestParam TourDto dto,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        return tourService.create(dto, principal);
    }

    @PutMapping("/tours/updateTour/{tourId}")
    public TourDto updateTour(
            @PathVariable long tourId,
            @RequestParam TourUpdateDto dto,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        return tourService.update(tourId, dto, principal);
    }

    @PostMapping("/tours/removeTour/{tourId}")
    public void removeTour(
            @PathVariable long tourId,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        tourService.remove(tourId, principal);
    }

    @PostMapping("/countries/createCountry")
    public CountryDto createCountry(
            @RequestParam CountryCreateDto dto,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        return countryService.create(dto, principal);
    }

    @PutMapping("/countries/updateCountry/{countryId}")
    public CountryDto updateCountry(
            @PathVariable long countryId,
            @RequestParam CountryDto dto,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        return countryService.update(countryId, dto, principal);
    }

    @PostMapping("/countries/removeCountry/{countryId}")
    public void removeCountry(
            @PathVariable long countryId,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        countryService.remove(countryId, principal);
    }

    @PostMapping("/hotels/createHotel")
    public HotelDto createHotel(
            @RequestParam HotelCreateDto dto,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        return hotelService.create(dto, principal);
    }

    @PutMapping("/hotels/updateHotel/{hotelId}")
    public HotelDto updateHotel(
            @PathVariable long hotelId,
            @RequestParam HotelDto dto,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        return hotelService.update(hotelId, dto, principal);
    }

    @PostMapping("/hotels/removeHotel/{hotelId}")
    public void removeHotel(
            @PathVariable long hotelId,
            @AuthenticationPrincipal AdminPrincipal principal
    ) {
        hotelService.remove(hotelId, principal);
    }
}
