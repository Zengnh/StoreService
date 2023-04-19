package com.store.storeservice.bean.vo;

import com.store.storeservice.bean.db.TableUser;

public class VOUserInfo {
    public String  uid= "123";
    public String name="Test1";
    public String cover=": ";
    public String sex="0";
    public String mobile="0965391369";
    public String address="";
    public String reg_time="2022-02-15 16:20:30";
    public String password="123456";
    public String birthday="";
    public String money="0";
    public String bazaar_id="0";
    public String points="0";
    public String nick_name="Test1";
    public String city_id="0";
    public String area_id="0";
    public String access_token="bf40UfRh1xFGkRckCFXYCHZaGjdKtAuapXAJXanmlf4";
    public void setUserInfo(TableUser user){
        uid=user.getUid();
        name=user.getName();
        sex=user.getSex();

    }
}
