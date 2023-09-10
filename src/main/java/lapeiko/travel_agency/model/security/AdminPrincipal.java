package lapeiko.travel_agency.model.security;

import lapeiko.travel_agency.model.admin.Admin;
import lombok.Value;

@Value
public class AdminPrincipal implements AccountPrincipal {
    long id;

    @Override
    public AccountRole getRole() {
        return AccountRole.ADMIN;
    }

    public static AdminPrincipal from(Admin admin) {
        return new AdminPrincipal(admin.getId());
    }
}
