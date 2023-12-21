package com.eaprovide.electroapparat.service;

import com.eaprovide.electroapparat.model.User;
import com.eaprovide.electroapparat.model.UserDetailsImpl;
import com.eaprovide.electroapparat.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByUsername(username).orElseThrow(() -> {
            return new UsernameNotFoundException(
                    String.format("User '$s' not found", username)
            );
        });

        return UserDetailsImpl.build(user);
    }
}
