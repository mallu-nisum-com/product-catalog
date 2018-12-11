package com.onimurasame.productcatalog.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductControllerTest {

    @Disabled("To see how the Coverage looks like")
    @Test
    @DisplayName("Test GET /products")
    void test_getProducts() throws IOException {
        ProductController productController = new ProductController();
        String responseEntity = productController.findAll();
        assertNotNull(responseEntity);
          }

}
