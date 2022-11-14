package com.store.storeservice.bean.vo;

import lombok.Data;

@Data
public class Category {
    private String category_id;
    private String category_name;
    private String category_icon;

    public Category(String category_id, String category_name, String category_icon) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_icon = category_icon;
    }
}