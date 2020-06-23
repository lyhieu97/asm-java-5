package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void save(Product product){
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id){
        productRepository.deleteById(id);
    }

    @Override
    public Product get(Integer id){
        return productRepository.findById(id).get();
    }

    @Override
    public Product find(int id) {
        return productRepository.find(id);
    }
}
