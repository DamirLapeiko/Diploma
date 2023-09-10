package lapeiko.travel_agency.model.security;

import org.springframework.security.core.GrantedAuthority;

public enum AccountRole implements GrantedAuthority {
    ADMIN,
    CLIENT;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
