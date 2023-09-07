package lapeiko.travel_agency.model.hotel;

import jakarta.persistence.*;
import lapeiko.travel_agency.model.BaseEntity;
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


}
