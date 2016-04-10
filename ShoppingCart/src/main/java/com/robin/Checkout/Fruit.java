package com.robin.Checkout;

public class Fruit {
	String Desc;
	double price;
	
	/* Constructor for setting the desc and price*/
	public Fruit(String desc, double price) {
		super();
		Desc = desc;
		this.price = price;
	}

	
	public String getDesc() { //getter for descritpion
		return Desc;
	}


	public double getPrice() {// getter for price
		return price;
	}


	@Override
	public String toString() {
		return "Fruit [Desc=" + Desc + ", price=" + price + "]";
	}
	
	
}
