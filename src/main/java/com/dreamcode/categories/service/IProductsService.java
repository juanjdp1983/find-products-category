package com.dreamcode.categories.service;

import com.dreamcode.categories.model.Products;

import java.util.List;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 18:36
 * @project categories
 */
public interface IProductsService {

    List<Products> getProductList();

    List<Products> getListByKeyWord(String keyWord);
}
