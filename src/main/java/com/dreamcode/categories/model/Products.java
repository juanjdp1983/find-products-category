package com.dreamcode.categories.model;

import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:21
 * @project categories
 */

public class Products {
    private Long id;
    private String name;
    private List<String> category;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Products(Long id, String name, List<String> category, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
    }
}
