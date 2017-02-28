package ua.atm.controller.dto.service.impl;

import ua.atm.controller.dto.domain.atmDTO.AtmDTO;
import ua.atm.controller.dto.service.AtmDTOService;

import java.util.List;

/**
 * Created by a.lomako on 2/27/2017.
 */
public class SimpleAtmDTOService implements AtmDTOService {
    @Override
    public List<AtmDTO> findAll() {
        return null;
    }

    @Override
    public AtmDTO findByCityName(String city) {
        return null;
    }

    @Override
    public AtmDTO update(AtmDTO atmDTO) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public AtmDTO save(AtmDTO atmDTO) {
        return null;
    }
}
