package lapeiko.travel_agency.model.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lapeiko.travel_agency.model.BaseEntity;
import lapeiko.travel_agency.model.tour.Tour;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Admin extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "name", nullable = false)
    private String name;

}
