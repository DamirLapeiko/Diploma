package lapeiko.travel_agency.model.security;

import lapeiko.travel_agency.model.client.Client;
import lombok.Value;

@Value
public class ClientPrincipal implements AccountPrincipal {
    long id;

    @Override
    public AccountRole getRole() {
        return AccountRole.CLIENT;
    }

    public static ClientPrincipal from(Client client) {
        return new ClientPrincipal(client.getId());
    }
}
