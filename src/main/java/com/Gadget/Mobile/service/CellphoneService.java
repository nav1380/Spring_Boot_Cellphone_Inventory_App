package com.Gadget.Mobile.service;

import com.Gadget.Mobile.dto.CellphoneDto;
import com.Gadget.Mobile.model.Cellphone;
import com.Gadget.Mobile.repository.CellphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellphoneService {

    @Autowired
    CellphoneRepository cellphoneRepository;

    public List<Cellphone> getAllPhones() {
        return cellphoneRepository.findAll();
    }

    public Cellphone getPhoneById(Long id) {
        return cellphoneRepository.findById(id).orElse(null);
    }

    public Cellphone addCellphone(CellphoneDto cellphoneDto) {
        Cellphone cellphone = mapToEntity(cellphoneDto);
        return cellphoneRepository.save(cellphone);
    }

    public Cellphone updateCellphone(Long id, CellphoneDto cellphoneDto) {
        Cellphone cellphone = getPhoneById(id);
        updateEntity(cellphone, cellphoneDto);
        return cellphoneRepository.save(cellphone);
    }

    public void deleteCellphone(Long id) {
        Cellphone cellphone = getPhoneById(id);
        cellphoneRepository.delete(cellphone);
    }

    private Cellphone mapToEntity(CellphoneDto cellphoneDto) {
        Cellphone cellphone = new Cellphone();
        cellphone.setBrand(cellphoneDto.getBrand());
        cellphone.setModelName(cellphoneDto.getModelName());
        cellphone.setCategory(cellphoneDto.getCategory());
        return cellphone;
    }

    private void updateEntity(Cellphone cellphone, CellphoneDto cellphoneDto) {
        cellphone.setBrand(cellphoneDto.getBrand());
        cellphone.setModelName(cellphoneDto.getModelName());
        cellphone.setCategory(cellphoneDto.getCategory());
    }
}
