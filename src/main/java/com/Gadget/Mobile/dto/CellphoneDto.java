package com.Gadget.Mobile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CellphoneDto {

    @NotEmpty(message = "The brand is required!")
    private String brand;

    @NotEmpty(message = "The category is required!")
    private String category;

    @NotEmpty(message = "The model name is required!")
    private String modelName;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
