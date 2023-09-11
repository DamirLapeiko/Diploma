package lapeiko.travel_agency.service.impl;


import lapeiko.travel_agency.model.client.Client;
import lapeiko.travel_agency.model.client.ClientSignInDto;
import lapeiko.travel_agency.model.client.ClientSignUpDto;
import lapeiko.travel_agency.repository.ClientRepository;
import lapeiko.travel_agency.service.AccessTokenService;
import lapeiko.travel_agency.service.ClientService;
import lapeiko.travel_agency.service.exception.BusinessException;
import lapeiko.travel_agency.model.security.AccessToken;
import lapeiko.travel_agency.model.security.ClientPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepo;
    private final AccessTokenService accessTokenService;
    private final PasswordEncoder passwordEncoder;
    private final TransactionOperations txOps;

    @Override
    public AccessToken signIn(ClientSignInDto dto) {
        Client client = clientRepo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadCredentialsException(""));

        if (!passwordEncoder.matches(dto.getPassword(), client.getPasswordHash())) {
            throw new BadCredentialsException("");
        }

        ClientPrincipal principal = ClientPrincipal.from(client);
        return accessTokenService.generate(principal);
    }

    @Override
    public AccessToken signUp(ClientSignUpDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        Client client = create(dto, passwordHash);
        ClientPrincipal principal = ClientPrincipal.from(client);
        return accessTokenService.generate(principal);
    }

    private Client create(ClientSignUpDto dto, String passwordHash) {
        return txOps.execute(tx -> {
            boolean existsByEmail = clientRepo.findByEmail(dto.getEmail()).isPresent();
            if (existsByEmail) {
                throw new BusinessException("Account does not exist");
            }
            Client client = new Client()
                    .setEmail(dto.getEmail())
                    .setPasswordHash(passwordHash)
                    .setLastName(dto.getLastName())
                    .setFirstName(dto.getFirstName());
            clientRepo.create(client);
            return client;
        });
    }
}

