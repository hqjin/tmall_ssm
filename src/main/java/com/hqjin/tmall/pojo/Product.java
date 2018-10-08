package com.hqjin.tmall.pojo;

import java.util.Date;

public class Product {
    private Integer id;

    private String name;

    private String subTitle;

    private Float originalPrice;

    private Float promoterPrice;

    private Integer stock;

    private Integer cid;

    private Date createDate;

    private Category category;

    private ProductImage firstProductImage;

    public ProductImage getFirstProductImage(){
        return firstProductImage;
    }

    public void setFirstProductImage(ProductImage productImage){
        //犯错：找了还久的bug！此处的“productImage”误命名为“firsProductImage”!
        firstProductImage=productImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category=category;
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
        this.name = name == null ? null : name.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Float getPromoterPrice() {
        return promoterPrice;
    }

    public void setPromoterPrice(Float promoterPrice) {
        this.promoterPrice = promoterPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}