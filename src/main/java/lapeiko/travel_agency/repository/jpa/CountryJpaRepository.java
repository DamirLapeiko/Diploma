package lapeiko.travel_agency.repository.jpa;

import lapeiko.travel_agency.model.country.Country;
import lapeiko.travel_agency.repository.CountryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryJpaRepository extends BaseJpaRepository<Country, Long>
        implements CountryRepository {

    public CountryJpaRepository() {
        super(Country.class);
    }

    @Override
    public List<Country> getAllCountries(int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT country
                        FROM Country country
                        """, Country.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
