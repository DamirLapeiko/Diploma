package lapeiko.travel_agency.model.country;

import jakarta.persistence.*;
import lapeiko.travel_agency.model.BaseEntity;
import lapeiko.travel_agency.model.admin.Admin;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "country")
@Getter
@Setter
@Accessors(chain = true)
public class Country extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Admin admin;

}
