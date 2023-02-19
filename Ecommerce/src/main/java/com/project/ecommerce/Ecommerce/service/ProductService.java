package com.project.ecommerce.Ecommerce.service;

import com.project.ecommerce.Ecommerce.dao.ProductRepository;
import com.project.ecommerce.Ecommerce.model.Product;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public JSONArray getProduct(String category){
        List<Product> productList = productRepository.findAll();

        JSONArray productArr = new JSONArray();

        for (Product product: productList) {
            if(product.getCategory().equals(category)){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", product.getId());
                jsonObject.put("name", product.getName());
                jsonObject.put("price", product.getPrice());
                jsonObject.put("description", product.getDescription());
                jsonObject.put("category", product.getCategory());
                jsonObject.put("brand", product.getBrand());
                productArr.put(jsonObject);
            }

        }

        return productArr;
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }


}
