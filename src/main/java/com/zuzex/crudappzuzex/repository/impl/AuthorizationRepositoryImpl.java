package com.zuzex.crudappzuzex.repository.impl;

import com.zuzex.crudappzuzex.repository.AuthorizationRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class AuthorizationRepositoryImpl implements AuthorizationRepository {
    private final Map<String , String> tokenUserMap = new ConcurrentHashMap<>();

     @Override
    public void save(String login, String token) {
        tokenUserMap.put(token,login);
    }

    @Override
    public void delete(String token) {
         tokenUserMap.remove(token.substring(7));

    }

    @Override
    public Optional<String> getUserLogin(String token) {
        String subToken = token.substring(7);
        String login = tokenUserMap.get(subToken);
        return Optional.ofNullable(login);
    }
}
