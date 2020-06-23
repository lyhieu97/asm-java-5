package com.example.demo.service;


import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public void save(Product product);
    public void delete(Integer id);
    public Product get(Integer id);
    public Product find(int id);
}
