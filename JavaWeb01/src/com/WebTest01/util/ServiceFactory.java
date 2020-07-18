package com.WebTest01.util;

public class ServiceFactory {
    //创建代理service对象
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }

}
