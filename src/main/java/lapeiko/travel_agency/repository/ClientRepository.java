package lapeiko.travel_agency.repository;

import lapeiko.travel_agency.model.client.Client;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long>{
    Optional<Client> findByEmail(String email);

}
