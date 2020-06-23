package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table( name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String images;
    private Integer price;
    private String size;
    private String descriptionn;
    private Integer cid;

    public Product(){
    }

    public Product(String name, String images, Integer price, String size, String descriptionn, Integer cid) {
        this.name = name;
        this.images = images;
        this.price = price;
        this.size = size;
        this.descriptionn = descriptionn;
        this.cid = cid;
    }

    public Product(Integer id, String name, String images, Integer price, String size, String descriptionn, Integer cid) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.price = price;
        this.size = size;
        this.descriptionn = descriptionn;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images='" + images + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", descriptionn='" + descriptionn + '\'' +
                ", cid=" + cid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescriptionn() {
        return descriptionn;
    }

    public void setDescriptionn(String descriptionn) {
        this.descriptionn = descriptionn;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
