package com.example.android.interfacdemo;

public class CallBackUtils {
  
    private static CallBack mCallBack;  
  
    public static void setCallBack(CallBack callBack) {  
        mCallBack = callBack;  
    }  
  
    public static void doCallBackMethod(String info){

        mCallBack.doSomeThing(info);  
    }  
  
}  