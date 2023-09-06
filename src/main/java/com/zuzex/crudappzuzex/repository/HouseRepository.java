package com.zuzex.crudappzuzex.repository;

import com.zuzex.crudappzuzex.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    Optional<List<House>> getHouseByPersonId(Long personId);
     House findHouseByAdress(String adressName);
}
