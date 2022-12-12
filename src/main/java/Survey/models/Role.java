package Survey.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, COMPANY;

    @Override
    public String getAuthority() {
        return name();
    }
}
