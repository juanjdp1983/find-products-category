package com.dreamcode.categories.model;

import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:28
 * @project categories
 */
public class Furniture extends Products {

    private String color;

    public Furniture(Long id, String name, List<String> category, String description, String color) {
        super(id, name, category, description);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
