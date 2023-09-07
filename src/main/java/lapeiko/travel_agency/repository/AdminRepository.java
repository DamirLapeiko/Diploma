package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.admin.Admin;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);

}
