package com.example.demo.controller;



import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("list")
    public ModelAndView listProduct(){
        ModelAndView modelAndView = new ModelAndView("product/list", "Product", productRepository.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView saveProduct(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView saveProduct(@ModelAttribute("product")Product product) {
            productRepository.save(product);
            ModelAndView modelAndView = new ModelAndView("product/create");
            modelAndView.addObject("message", "Product: " + product.getName() + " create successfully !");
            return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productRepository.findById(id));
        return "product/delete";
    }

    @PostMapping("delete")
    public ModelAndView delete(@ModelAttribute("product") Product product){
        productRepository.deleteById(product.getId());
        ModelAndView modelAndView = new ModelAndView("product/delete");
        modelAndView.addObject("message", "Product name: " + product.getName() + " deleted successfully !");
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productRepository.findById(id));
        return "product/update";
    }
    @PostMapping("update")
    public ModelAndView update(@ModelAttribute("product") Product product){
        productRepository.save(product);
        ModelAndView modelAndView = new ModelAndView("product/update");
        modelAndView.addObject("message", "Product id: " + product.getId() + " updated successfully !");
        return modelAndView;
    }
}
