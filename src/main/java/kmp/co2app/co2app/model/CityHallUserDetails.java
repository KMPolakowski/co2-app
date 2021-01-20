package kmp.co2app.co2app.model;

import kmp.co2app.co2app.domain.CityHall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CityHallUserDetails implements UserDetails {

    private CityHall cityHall;

    public CityHallUserDetails(CityHall cityHall) {
        this.cityHall = cityHall;
    }

    public CityHall getCityHall() {
        return cityHall;
    }

    public void setCityHall(CityHall cityHall) {
        this.cityHall = cityHall;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return cityHall.getToken();
    }

    @Override
    public String getUsername() {
        return cityHall.getCityName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
