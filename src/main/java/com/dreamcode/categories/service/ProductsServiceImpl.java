package com.dreamcode.categories.service;

import com.dreamcode.categories.model.Electronics;
import com.dreamcode.categories.model.Furniture;
import com.dreamcode.categories.model.HomeAppliances;
import com.dreamcode.categories.model.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:37
 * @project categories
 */

@Service
public class ProductsServiceImpl implements IProductsService {

    /**
     * Get products list
     *
     * @return
     */
    public List<Products> getProductList() {
        return buildProductsList();
    }

    /**
     * Get products list by keyword
     * We look for the keyword in all the fields that may exists
     * search at all levels
     *
     * @param keyWord
     * @return
     */
    public List<Products> getListByKeyWord(String keyWord) {
        List<Products> productsList = new ArrayList<>();

        buildProductsList().forEach(item -> {

            Long findProduct = item.getCategory().stream()
                    .filter(itemCategory -> itemCategory.toUpperCase().contains(keyWord.toUpperCase())).count();

            if (keyWord.equalsIgnoreCase(item.getDescription()) || keyWord.equalsIgnoreCase(item.getName()) || findProduct > 0) {
                productsList.add(item);
            }

        });
        return productsList;

    }

    /**
     * private method, only for build a list
     *
     * @return
     */
    private List<Products> buildProductsList() {
        List<Products> productsList = new ArrayList<>();
        Products productNotebook = new Electronics(1L, "Notebook HP", Arrays.asList("electronics", "notebook", "lapto"), "notebook HP", "HP", "1 year");
        Products productCamera = new Electronics(2L, "Camera", Arrays.asList("electronics", "camera", "photography"), "camera nikon", "nikon", "1 year");
        Products productFurnitureSofa = new Furniture(3L, "sofa", Arrays.asList("furniture", "sofa", "furniture"), "big sofa", "white");
        Products productFurnitureChair = new Furniture(4L, "chair", Arrays.asList("furniture", "chair", "office chair"), "office chair", "black");
        Products productHomeAppliancesKitchen = new HomeAppliances(5L, "Kitchen", Arrays.asList("home appliances", "electric kitchen", "Kitchen"), "electric kitchen", "kitchen");
        Products productHomeAppliancesWashing = new HomeAppliances(6L, "Washing machine", Arrays.asList("home appliances", "Washing", "Kitchen"), "Home appliances", "washing");

        productsList.add(productNotebook);
        productsList.add(productCamera);
        productsList.add(productFurnitureSofa);
        productsList.add(productFurnitureChair);
        productsList.add(productHomeAppliancesKitchen);
        productsList.add(productHomeAppliancesWashing);
        return productsList;
    }
}
