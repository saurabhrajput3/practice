package com.project.ecommerce.Ecommerce.controller;

import com.project.ecommerce.Ecommerce.model.Product;
import com.project.ecommerce.Ecommerce.model.User;
import com.project.ecommerce.Ecommerce.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<String> saveProduct(@RequestBody String product){
        JSONObject json = new JSONObject(product);
        Product p=setProduct(json);
        productService.saveProduct(p);
        return new ResponseEntity<>("Product saved", HttpStatus.CREATED);

    }

    @GetMapping(value = "/getProduct")
    public ResponseEntity getProductByCtg(@RequestParam String category){
        JSONArray productDetails = productService.getProduct(category);

        return new ResponseEntity<>(productDetails.toString(), HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteProduct")
    public void getProduct(@RequestParam Integer productId){
         productService.deleteProduct(productId);
    }




    private Product setProduct(JSONObject json) {
        Product pr=new Product();
        pr.setId(json.getInt("id"));
        pr.setName(json.getString("name"));
        pr.setPrice(json.getInt("price"));
        pr.setDescription(json.getString("description"));
        pr.setCategory(json.getString("category"));
        pr.setBrand(json.getString("brand"));
        return pr;
    }
}
