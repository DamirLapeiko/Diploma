package lapeiko.travel_agency.repository.jpa;

import lapeiko.travel_agency.model.hotel.Hotel;
import lapeiko.travel_agency.repository.HotelRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HotelJpaRepository extends BaseJpaRepository<Hotel, Long>
        implements HotelRepository {

    public HotelJpaRepository() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> getAllHotels(int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT hotel
                        FROM Hotel hotel
                        """, Hotel.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public Optional<Hotel> getHotelByFeatures(String features) {
        return entityManager.createQuery("""
                        SELECT hotel
                        FROM Hotel hotel
                        WHERE hotel.features = features
                        """, Hotel.class)
                .setParameter("features", features)
                .getResultStream()
                .findFirst();
    }
}
