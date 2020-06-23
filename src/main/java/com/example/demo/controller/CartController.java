package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String cart(){
        return "cart/index";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session){
        if(session.getAttribute("cart") == null){
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(productRepository.find(id), 1));
            session.setAttribute("cart", cart);
        }else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExists(id, cart);
            if(index == -1){
                cart.add(new Item(productRepository.find(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "cart/index";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, HttpSession session){
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "cart/index";
    }

    private int isExists(int id, List<Item> cart){
        for (int i = 0; i < cart.size(); i++){
            if(cart.get(i).getProduct().getId()==id){
                return i;
            }
        }
        return -1;
    }
}
