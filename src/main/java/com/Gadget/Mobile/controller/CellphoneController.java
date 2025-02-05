package com.Gadget.Mobile.controller;

import com.Gadget.Mobile.dto.CellphoneDto;
import com.Gadget.Mobile.model.Cellphone;
import com.Gadget.Mobile.service.CellphoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cellphone")
public class CellphoneController {

    @Autowired
    CellphoneService cellphoneService;

    @GetMapping({"", "/"})
    public String showCellphones(Model model) {
        List<Cellphone> cellphones = cellphoneService.getAllPhones();
        model.addAttribute("cellphones", cellphones);
        return "cellphones";
    }

    @GetMapping("/add")
    public String showAddPage(Model model) {
        model.addAttribute("cellphoneDto", new CellphoneDto());
        return "createPhone";
    }

    @PostMapping("/add")
    public String addCellphone(@Valid @ModelAttribute CellphoneDto cellphoneDto, BindingResult result) {
        if (result.hasErrors()) {
            return "createPhone";
        }

        cellphoneService.addCellphone(cellphoneDto);
        return "redirect:/cellphone";
    }

    @GetMapping("/edit/{id}")
    public String showAddPage(@PathVariable Long id, Model model) {
        Cellphone cellphone = cellphoneService.getPhoneById(id);
        CellphoneDto cellphoneDto = new CellphoneDto();
        cellphoneDto.setBrand(cellphone.getBrand());
        cellphoneDto.setCategory(cellphone.getCategory());
        cellphoneDto.setModelName(cellphone.getModelName());

        model.addAttribute("cellphoneDto", cellphoneDto);
        model.addAttribute("Id", id);
        return "editPhone";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute CellphoneDto cellphoneDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productId", id);
            return "products/computerEditParts";
        }

        cellphoneService.updateCellphone(id, cellphoneDto);
        return "redirect:/cellphone";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        cellphoneService.deleteCellphone(id);
        return "redirect:/cellphone";
    }
}
