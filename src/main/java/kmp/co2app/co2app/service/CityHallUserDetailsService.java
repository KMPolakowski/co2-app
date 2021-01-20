package kmp.co2app.co2app.service;

import kmp.co2app.co2app.domain.CityHall;
import kmp.co2app.co2app.model.CityHallUserDetails;
import kmp.co2app.co2app.repository.CityHallRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class CityHallUserDetailsService implements UserDetailsService {

    private CityHallRepository cityHallRepository;

    public CityHallUserDetailsService(CityHallRepository cityHallRepository) {
        this.cityHallRepository = cityHallRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<CityHall> optional = cityHallRepository.findByCityName(s);

        System.out.println(s);

        if(optional.isEmpty())
        {
            throw new UsernameNotFoundException(s + " not found");
        }

        return new CityHallUserDetails(optional.get());
    }
}
