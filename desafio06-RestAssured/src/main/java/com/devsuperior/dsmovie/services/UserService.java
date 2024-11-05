package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.entities.Role;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.projections.UserDetailsProjection;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.services.exceptions.ForbiddenException;
import com.devsuperior.dsmovie.services.exceptions.UnauthorizedException;
import com.devsuperior.dsmovie.utils.CustomUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CustomUserUtil userUtil;

    public User authenticated() {
        try {
            String username = userUtil.getLoggedUsername();
            return repository.findByUsername(username).orElseThrow(() -> new UnauthorizedException("User not found"));
        } catch (UnauthorizedException e) {
            throw new UnauthorizedException("Invalid user credentials");
        } catch (Exception e) {
            throw new ForbiddenException("Access denied");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Email not found");
        }

        User user = new User();
        user.setUsername(result.get(0).getUsername());
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection projection : result) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }
}