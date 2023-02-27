package com.dreamcode.categories.controller;

import com.dreamcode.categories.model.Products;
import com.dreamcode.categories.service.IProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:20
 * @project categories
 */
@RestController
public class ProductsController {

    private IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    /**
     * get list of all products
     *
     * @return
     */
    @GetMapping(value = "/products/list")
    public ResponseEntity<List<Products>> getList() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productsService.getProductList());
    }

    /**
     * Endpoint get list of products by word
     *
     * @param keyword required
     * @return
     */
    @GetMapping(value = "/products/keyword/{keyword}")
    public ResponseEntity<List<Products>> getListByKeyWord(@PathVariable String keyword) {
        List<Products> productsList = this.productsService.getListByKeyWord(keyword);

        if (productsList.size() > 0)
            return ResponseEntity.status(HttpStatus.OK).body(productsList);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productsList);
    }

}
