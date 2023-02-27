package com.dreamcode.categories.controller;

import com.dreamcode.categories.model.Electronics;
import com.dreamcode.categories.model.Furniture;
import com.dreamcode.categories.model.HomeAppliances;
import com.dreamcode.categories.model.Products;
import com.dreamcode.categories.service.IProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.naming.ServiceUnavailableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author juandelgado
 * @created 27 / 02 / 2023 - 19:25
 * @project categories
 */
@ExtendWith(MockitoExtension.class)
public class ProductsControllerTest {

    private ProductsController productsController;

    @Mock
    IProductsService productsService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        productsController = new ProductsController(productsService);
        mockMvc = MockMvcBuilders.standaloneSetup(productsController)
                .setControllerAdvice(new ServiceUnavailableException())
                .build();
    }

    /**
     * product list test OK
     *
     * @throws Exception
     */
    @Test
    public void getProductListOk() throws Exception {
        Mockito.when(productsService.getProductList()).thenReturn(buildProductsList());
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/products/list"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertNotNull(response.getContentAsString());
    }

    /**
     * products list by keyword test not found
     *
     * @throws Exception
     */
    @Test
    public void getListProductsByKeyWordError() throws Exception {
        List<Products> productsList = new ArrayList<>();
        Mockito.when(productsService.getListByKeyWord(any())).thenReturn(productsList);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/products/keyword/{keyword}", "any"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    /**
     * products list by keyword test OK
     *
     * @throws Exception
     */
    @Test
    public void getListProductsByKeyWordOk() throws Exception {
        Mockito.when(productsService.getListByKeyWord("electronic")).thenReturn(buildProductsListFilter());

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/products/keyword/{keyword}", "electronic"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertNotNull(response.getContentAsString());
    }


    /**
     * private method, only for build a list test
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
        Products productHomeAppliancesWashing = new HomeAppliances(6L, "Washing machine", Arrays.asList("home appliances", "electric kitchen", "Kitchen"), "Home appliances", "washing");

        productsList.add(productNotebook);
        productsList.add(productCamera);
        productsList.add(productFurnitureSofa);
        productsList.add(productFurnitureChair);
        productsList.add(productHomeAppliancesKitchen);
        productsList.add(productHomeAppliancesWashing);
        return productsList;
    }

    /**
     * private method, only for build a list test by filter
     *
     * @return
     */
    private List<Products> buildProductsListFilter() {
        List<Products> productsList = new ArrayList<>();
        Products productNotebook = new Electronics(1L, "Notebook HP", Arrays.asList("electronics", "notebook", "lapto"), "notebook HP", "HP", "1 year");
        Products productCamera = new Electronics(2L, "Camera", Arrays.asList("electronics", "camera", "photography"), "camera nikon", "nikon", "1 year");

        productsList.add(productNotebook);
        productsList.add(productCamera);
        return productsList;
    }
}
