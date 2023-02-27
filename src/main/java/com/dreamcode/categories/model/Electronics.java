package com.dreamcode.categories.model;

import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:23
 * @project categories
 */
public class Electronics extends Products {
    private String brand;
    private String warranty;

    public Electronics(Long id, String name, List<String> category, String description, String brand, String warranty) {
        super(id, name, category, description);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}
