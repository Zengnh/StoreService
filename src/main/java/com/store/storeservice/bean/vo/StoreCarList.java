package com.store.storeservice.bean.vo;

import lombok.Data;

import java.util.List;

@Data
public class StoreCarList {
    String shop_name;//", "bbb");
    String shop_id;//", "aaa");
    List<Cart> list;
}
