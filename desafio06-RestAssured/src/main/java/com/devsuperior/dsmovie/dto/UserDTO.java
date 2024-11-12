package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String username;

    private List<String> roles = new ArrayList<>();

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        username = entity.getUsername();
        for (GrantedAuthority role : entity.getRoles()){
          roles.add(role.getAuthority());
        }

    }

    public Long getId() {
        return id;
    }
}


