package lapeiko.travel_agency.model.tour;

import jakarta.persistence.*;
import lapeiko.travel_agency.model.BaseEntity;
import lapeiko.travel_agency.model.admin.Admin;
import lapeiko.travel_agency.model.client.Client;
import lapeiko.travel_agency.model.country.Country;
import lapeiko.travel_agency.model.hotel.Hotel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Tour extends BaseEntity {
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "duration", nullable = false)
    private Instant duration;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Enumerated
    @Column(name = "tour_type", nullable = false)
    private TourType tourType;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Admin admin;

    @ManyToMany
    @JoinTable(
            name = "tour_client",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Tour tour = (Tour) o;
        return getId() != null && Objects.equals(getId(), tour.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
