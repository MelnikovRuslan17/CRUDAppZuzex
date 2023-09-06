package com.zuzex.crudappzuzex.service;

import com.zuzex.crudappzuzex.exception.BadRequestException;
import com.zuzex.crudappzuzex.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
            return personRepository.findByLogin(username).orElseThrow(()->
                    new BadRequestException("Bad credential for" + username));
    }
}
