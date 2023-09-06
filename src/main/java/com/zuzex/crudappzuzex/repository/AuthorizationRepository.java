package com.zuzex.crudappzuzex.repository;

import java.util.Optional;

public interface AuthorizationRepository {
    void save(String login, String token);
    void delete(String token);
    Optional<String> getUserLogin(String token);
}
