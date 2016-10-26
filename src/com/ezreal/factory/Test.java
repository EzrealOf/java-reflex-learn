package com.ezreal.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws FileNotFoundException, IOException {
		  Properties pro=init.getPro();
	        fruit f=Factory.getInstance(pro.getProperty("banana"));
	        if(f!=null){
	            f.eat();
	        }
	}

}
class init{
    public static Properties getPro() throws FileNotFoundException, IOException{
        Properties pro=new Properties();
        File f=new File("fruit.properties");
        if(f.exists()){
            pro.load(new FileInputStream(f));
        }else{
            pro.setProperty("apple", "com.ezreal.factory.Apple");
            pro.setProperty("banana", "com.ezreal.factory.Banana");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}