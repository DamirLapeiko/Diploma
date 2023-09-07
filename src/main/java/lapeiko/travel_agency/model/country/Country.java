package lapeiko.travel_agency.model.country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lapeiko.travel_agency.model.BaseEntity;
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

}
