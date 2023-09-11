package lapeiko.travel_agency.service;

import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourUpdateDto;
import lapeiko.travel_agency.model.security.AdminPrincipal;

public interface TourAdminService {

    TourDto create(TourDto dto, AdminPrincipal principal);

    TourDto update(long id, TourUpdateDto dto, AdminPrincipal principal);

    void remove(long id, AdminPrincipal principal);
}
