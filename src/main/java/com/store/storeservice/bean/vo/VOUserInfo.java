package com.store.storeservice.bean.vo;

import com.store.storeservice.bean.db.TableUser;

public class VOUserInfo {
    public String uid= "";
    public String name="";
    public String cover=": ";
    public int sex=0;
    public String mobile="";
    public String address="";
    public String reg_time="";
    public String password="";
    public String birthday="";
    public String money="";
    public String bazaar_id="";
    public String points="";
    public String nick_name="";
    public String city_id="";
    public String area_id="";
    public String access_token="bf40UfRh1xFGkRckCFXYCHZaGjdKtAuapXAJXanmlf4";
    public void setUserInfo(TableUser user){
        uid=user.getUid();
        name=user.getName();
        sex=user.getSex();
    }
}
