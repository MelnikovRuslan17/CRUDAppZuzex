package com.zuzex.crudappzuzex.service;

import com.zuzex.crudappzuzex.dto.house.HouseDto;
import com.zuzex.crudappzuzex.dto.house.UpdateHouseDto;
import com.zuzex.crudappzuzex.exception.BadRequestException;
import com.zuzex.crudappzuzex.exception.InternalServerException;
import com.zuzex.crudappzuzex.exception.UnauthorizedException;
import com.zuzex.crudappzuzex.model.House;
import com.zuzex.crudappzuzex.model.Person;
import com.zuzex.crudappzuzex.model.Role;
import com.zuzex.crudappzuzex.repository.HouseRepository;
import com.zuzex.crudappzuzex.repository.impl.AuthorizationRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseService {
    private final HouseRepository houseRepository;
    private final PersonService personService;
    private final AuthorizationRepositoryImpl authorizationRepository;

    public List<HouseDto> getAllHouses(String token, int limit) {
        String login = authorizationRepository.getUserLogin(token).
                orElseThrow(() -> new UnauthorizedException("Unauthorized error, please try again"));
        Person person = (Person) personService.loadUserByUsername(login);
        List<House> houseList = houseRepository.getHouseByPersonId(person.getId())
                .orElseThrow(() -> new InternalServerException("Can't get houses by person ID"));
        return houseList.stream()
                .map(o -> new HouseDto(o.getAdress()))
                .collect(Collectors.toList());
    }

    public House save(String token, String houseAdress) throws IOException {
        String login = authorizationRepository.getUserLogin(token)
                .orElseThrow(() -> new UnauthorizedException("UnathorizedException please try again"));
        Person person = (Person) personService.loadUserByUsername(login);
        House house = House.builder()
                .person(person)
                .adress(houseAdress)
                .build();
        return houseRepository.save(house);
    }

    public void delete(String token, String houseAdress) {
        authorizationRepository.getUserLogin(token)
                .orElseThrow(() -> new UnauthorizedException("UnathorizedException please try again"));
        House house = houseRepository.findHouseByAdress(houseAdress);
        try {
            houseRepository.delete(house);
        } catch (Exception e) {
            throw new InternalServerException("Server error, can not delete file: " + house);
        }
    }

    public House update(String token, String adressName, UpdateHouseDto newHouseDto) {

        authorizationRepository.getUserLogin(token)
                .orElseThrow(() -> new UnauthorizedException("Unauthorized error, please login again"));
        House house = houseRepository.findHouseByAdress(adressName);
        house.setAdress(newHouseDto.getAdressName());
        try {
            return houseRepository.save(house);
        } catch (Exception e) {
            throw new InternalServerException("Server error, can not update file: " + house);
        }
    }


}
