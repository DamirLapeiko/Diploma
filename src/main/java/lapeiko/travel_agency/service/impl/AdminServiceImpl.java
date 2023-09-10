package lapeiko.travel_agency.service.impl;

import lapeiko.travel_agency.model.admin.Admin;
import lapeiko.travel_agency.model.admin.AdminSignInDto;
import lapeiko.travel_agency.model.admin.AdminSignUpDto;
import lapeiko.travel_agency.model.security.AccessToken;
import lapeiko.travel_agency.model.security.AdminPrincipal;
import lapeiko.travel_agency.repository.AdminRepository;
import lapeiko.travel_agency.service.AccessTokenService;
import lapeiko.travel_agency.service.AdminService;
import lapeiko.travel_agency.service.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepo;
    private final AccessTokenService accessTokenService;
    private final PasswordEncoder passwordEncoder;
    private final TransactionOperations txOps;

    @Override
    public AccessToken signIn(AdminSignInDto dto) {
        Admin admin = adminRepo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadCredentialsException(""));

        if (!passwordEncoder.matches(dto.getPassword(), admin.getPasswordHash())) {
            throw new BadCredentialsException("");
        }

        AdminPrincipal principal = AdminPrincipal.from(admin);
        return accessTokenService.generate(principal);
    }

    @Override
    public AccessToken signUp(AdminSignUpDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        Admin admin = this.create(dto, passwordHash);
        AdminPrincipal principal = AdminPrincipal.from(admin);
        return accessTokenService.generate(principal);
    }

    private Admin create(AdminSignUpDto dto, String passwordHash) {
        return txOps.execute(tx -> {
            boolean existsByEmail = adminRepo.findByEmail(dto.getEmail()).isPresent();
            if (existsByEmail) {
                throw new BusinessException("");
            }
            Admin admin = new Admin()
                    .setEmail(dto.getEmail())
                    .setPasswordHash(passwordHash)
                    .setName(dto.getName());
            adminRepo.create(admin);
            return admin;
        });
    }
}
