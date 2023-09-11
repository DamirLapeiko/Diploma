package lapeiko.travel_agency.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lapeiko.travel_agency.service.TourClientService;
import lapeiko.travel_agency.service.util.TourSearchParameter;
import lapeiko.travel_agency.model.admin.AdminSignInDto;
import lapeiko.travel_agency.model.admin.AdminSignUpDto;
import lapeiko.travel_agency.model.client.ClientSignInDto;
import lapeiko.travel_agency.model.client.ClientSignUpDto;
import lapeiko.travel_agency.model.hotel.HotelDto;
import lapeiko.travel_agency.model.review.ReviewShortDto;
import lapeiko.travel_agency.model.security.AccessToken;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourShortDto;
import lapeiko.travel_agency.service.AdminService;
import lapeiko.travel_agency.service.ClientService;
import lapeiko.travel_agency.service.exception.NoSearchParameterException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public-api")
@RequiredArgsConstructor
@Tag(name = "Public API", description = "Endpoints that can be accessed without authentication")
public class PublicApiController {

    private final AdminService adminService;
    private final ClientService clientService;
    private final TourClientService tourService;

    @PostMapping("/clients")
    public AccessToken signUpClient(@RequestBody ClientSignUpDto dto) {
        return clientService.signUp(dto);
    }

    @PostMapping("/clients/access-tokens")
    public AccessToken signInClient(@RequestBody ClientSignInDto dto) {
        return clientService.signIn(dto);
    }

    @PostMapping("/admins")
    public AccessToken signUpClient(@RequestBody AdminSignUpDto dto) {
        return adminService.signUp(dto);
    }

    @PostMapping("/admins/access-tokens")
    public AccessToken sighInClient(@RequestBody AdminSignInDto dto) {
        return adminService.signIn(dto);
    }

    @GetMapping("/tours")
    public List<TourShortDto> getPageWithAllTours(@RequestParam int page) {
        return tourService.getPageWithAllTours(page);
    }

    @GetMapping("/hotels")
    public List<HotelDto> getPageWithAllHotels(@RequestParam int page) {
        return tourService.getPageWithAllHotels(page);
    }

    @GetMapping("/tours/{tourId}")
    public Optional<TourShortDto> getTourById(@PathVariable long tourId) {
        return tourService.getTourById(tourId);
    }

    @GetMapping("/toursByCountry")
    public List<TourShortDto> getPageWithToursByCountry(
            @RequestParam String query,
            @RequestParam int page
    ) {
        return tourService.getPageWithToursByCountry(query, page);
    }

    @GetMapping("/tours/{hotelFeatures}")
    public List<TourShortDto> getPageWithTourAndHotelByFeatures(
            @PathVariable String hotelFeatures,
            @RequestParam int page
    ) {
        return tourService.getPageWithTourAndHotelByFeatures(hotelFeatures, page);
    }

    @GetMapping("/tours/{tourType}")
    public List<TourDto> getPageWithTourByTourType(
            @PathVariable String tourType,
            @RequestParam int page
    ) {
        return tourService.getPageWithTourByTourType(tourType, page);
    }

    @GetMapping("/tourSearch")
    public List<TourShortDto> getToursByParameters(
            @RequestParam TourSearchParameter[] parameters,
            @RequestParam int page
    ) throws NoSearchParameterException {
    return tourService.getToursByParameters(parameters, page);
    }

    @GetMapping("/tour-reviews")
    public List<TourShortDto> getPageWithReviewsOnTour(
            @PathVariable ReviewShortDto dto,
            @RequestParam int page
    ) {
        return tourService.getPageWithReviewsOnTour(dto, page);
    }
}
