package com.gos.security;

import com.gos.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {
    
    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // Conta não expirada
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Conta não bloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Credenciais não expiradas
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Conta ativa
    @Override
    public boolean isEnabled() {
        return true;
    }
}