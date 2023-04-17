package com.store.storeservice.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    //    "河南大学", 10
    private String userName;

    public String token;
    public String userId;
    public String name;
}
