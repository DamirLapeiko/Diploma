package lapeiko.travel_agency.model.hotel;

import jakarta.persistence.*;
import lapeiko.travel_agency.model.BaseEntity;
import lapeiko.travel_agency.model.admin.Admin;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@Accessors(chain = true)
public class Hotel extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "stars", nullable = false)
    private int stars;

    @Enumerated(EnumType.STRING)
    @Column(name = "features", nullable = false)
    private HotelFeatures features;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Admin admin;
}
