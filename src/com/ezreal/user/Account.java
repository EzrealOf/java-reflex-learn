package com.ezreal.user;

/**
 * “¯––’À∫≈
 * @author Ezreal#
 *
 */
public class Account {
	private int id;
	private String name;
	private float money;
	public Account() {
	}
	public Account(int id,String name,float money) {
		this.id=id;
		this.name=name;
		this.money=money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money
				+ "]";
	}
	public void sayHello(String str){
		System.out.println("Hello "+str);
	}
	
	
}
