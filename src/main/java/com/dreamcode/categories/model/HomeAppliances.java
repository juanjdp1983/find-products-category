package com.dreamcode.categories.model;

import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:30
 * @project categories
 */
public class HomeAppliances extends Products {
    private String subcategories;

    public HomeAppliances(Long id, String name, List<String> category, String description, String subcategories) {
        super(id, name, category, description);
        this.subcategories = subcategories;
    }

    public String getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(String subcategories) {
        this.subcategories = subcategories;
    }
}
