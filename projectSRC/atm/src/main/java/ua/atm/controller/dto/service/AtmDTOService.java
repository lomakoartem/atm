package ua.atm.controller.dto.service;

import ua.atm.controller.dto.domain.atmDTO.AtmDTO;

import java.util.List;

/**
 * Created by a.lomako on 2/27/2017.
 */
public interface AtmDTOService {

    List<AtmDTO> findAll();

      AtmDTO  findByCityName(String city);

    AtmDTO update(AtmDTO atmDTO);

    void remove(Long id);

    AtmDTO save(AtmDTO atmDTO);

}
