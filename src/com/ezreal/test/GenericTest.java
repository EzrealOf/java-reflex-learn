package com.ezreal.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTest<T> {  
    
    public static void main(String[] args) {  
        GenericTest<String> test = new GenericTest<String>(){}; // �����ڲ���������ڱ���ʱ���У�ʵ����������ʱ����  
          
        Type typeClass1 = test.getClass().getGenericSuperclass();  
        System.out.println(typeClass1);  
          
        if (typeClass1 instanceof ParameterizedType) {  
            Type actualType1 = ((ParameterizedType)typeClass1).getActualTypeArguments()[0];  
              
            System.out.println(actualType1);  
        } else {  
            System.out.println(typeClass1 + " is Not ParameterizedType");  
        }  
          
        System.out.println(" ==================================== ");  
          
        GenericTest<String> test2 = new GenericTest<String>(); // ���еķ�������������ʱ����Object����  
        Type typeClass2 = test2.getClass().getGenericSuperclass();    
        System.out.println(typeClass2);  
          
        if (typeClass2 instanceof ParameterizedType) {  
            Type actualType2 = ((ParameterizedType)typeClass2).getActualTypeArguments()[0];  
              
            System.out.println(actualType2);  
        } else {  
            System.out.println(typeClass2 + " is Not ParameterizedType");  
        }  
          
    }  
  
}  
