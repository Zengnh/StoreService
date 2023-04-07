package com.store.storeservice.base;

public class UserThreadLocal {

    private UserThreadLocal(){}
    private static final ThreadLocal<User> LOCAL=new ThreadLocal<User>();
    public static void set(User user){
        LOCAL.set(user);
    }

    public static User get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
