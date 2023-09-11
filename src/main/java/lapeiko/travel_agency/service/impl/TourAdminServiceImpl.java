package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.model.tour.Tour;
import lapeiko.travel_agency.model.tour.TourDto;
import lapeiko.travel_agency.model.tour.TourUpdateDto;
import lapeiko.travel_agency.repository.AdminRepository;
import lapeiko.travel_agency.repository.TourRepository;
import lapeiko.travel_agency.service.exception.BusinessException;
import lapeiko.travel_agency.model.security.AdminPrincipal;
import lapeiko.travel_agency.service.TourAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TourAdminServiceImpl implements TourAdminService {

    private final TourRepository tourRepo;
    private final AdminRepository adminRepo;

    @Override
    @Transactional
    public TourDto create(TourDto dto, AdminPrincipal principal) {
        adminRepo.getReferenceById(principal.getId());
        Tour tour = new Tour();
        tour.setDate(dto.getDate());
        tour.setDuration(dto.getDuration());
        tour.setCost(dto.getCost());
        tour.setTourType(dto.getTourType());
        tourRepo.create(tour);
        return TourDto.from(tour);
    }

    @Override
    @Transactional
    public TourDto update(long id, TourUpdateDto dto, AdminPrincipal principal) {
        Tour tour = tourRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Tour is not found"));
        validateAccess(tour, principal);
        tour.setDate(dto.getDate());
        tour.setCost(dto.getCost());
        tour.setDuration(dto.getDuration());
        return TourDto.from(tour);
    }

    @Override
    @Transactional
    public void remove(long id, AdminPrincipal principal) {
        Tour tour = tourRepo.findById(id)
                .orElseThrow(() -> new BusinessException("Tour is not found"));
        validateAccess(tour, principal);
        tourRepo.remove(tour);
    }


    private void validateAccess(Tour tour, AdminPrincipal principal) {
        long authenticatedId = principal.getId();
        long ownerId = tour.getAdmin().getId();
        if (authenticatedId != ownerId) {
            throw new BusinessException("Access denied");
        }
    }
}
