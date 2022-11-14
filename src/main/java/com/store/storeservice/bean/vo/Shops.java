package com.store.storeservice.bean.vo;

import lombok.Data;

@Data
public class Shops {
    private String shop_id;
    private String category_id;
    private String shop_name;
    private String logo;
    private String business_time;
    private String delivery_type;
    private String mobile;
    private String phone;
    private String address;
    private String shop_introduce;
    private String lng;
    private String lat;
    private String distance;
    private String remark;

    public Shops(){}
    public Shops(String name,String add,String dist,String remark,String phone,String logo){
        setAddress(name);
        setShop_name(add);
        setLogo(logo);
        setPhone(phone);
        setDistance(dist);
        setRemark(remark);
    }

}
