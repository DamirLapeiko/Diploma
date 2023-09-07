package lapeiko.travel_agency.repository.jpa;

import lapeiko.travel_agency.model.client.Client;
import lapeiko.travel_agency.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ClientJpaRepository extends BaseJpaRepository<Client, Long>
        implements ClientRepository {

    public ClientJpaRepository() {
        super(Client.class);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT client
                        FROM Client client
                        WHERE lower(client.email) = lower(:email)
                        """, Client.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
