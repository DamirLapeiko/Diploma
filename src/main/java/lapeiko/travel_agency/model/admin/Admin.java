package lapeiko.travel_agency.model.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lapeiko.travel_agency.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "admin")
@Getter
@Setter
@Accessors(chain = true)
public class Admin extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    @Size(min = 4, message = "Password should be longer then 3 characters")
    private String passwordHash;

    @Column(name = "name", nullable = false)
    @Size(min = 5, message = "Name should be longer then 4 characters")
    private String name;

}
