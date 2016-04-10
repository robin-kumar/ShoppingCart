package com.robin.Checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.robin.Offer.BuyOneGetOneFree;
import com.robin.Offer.Offer;

public class CheckOutTest {
	
	Map<String,Fruit> fruitMaster=null;
	List<String> fruitTran =null;
	Checkout checkOut = null;
	Map<String,Offer> offer = null;

	@Before
	public void setUp() throws Exception {
		fruitMaster= new HashMap<String,Fruit>();
		checkOut = new Checkout();
    	
    	fruitMaster.put("Apple",new Fruit("Apple",0.60)); //put Apple details in the Fruit Master
    	fruitMaster.put("Orange",new Fruit("Orange",0.25)); // put Orange details in the Fruit Master
    	System.out.println("Fruit Master");
    	System.out.println(fruitMaster.toString());
    	checkOut.setStockFruit(fruitMaster); //set Fruit Master to Checkout Object
    	
    	fruitTran = new ArrayList<String>(
    	Arrays.asList("Apple", "Apple", "Orange","Apple","Orange","Orange","Apple")); //create Fruit transaction list
    	checkOut.setTranFruit(fruitTran); //set Fruit transaction details to checkout object
    	offer = new HashMap<String,Offer>();
		
	}
	
	@Test
	public void test1()
    {
    		System.out.println( "--------------------------------------------------------------------------");
    		System.out.println("Transaction list:"+fruitTran.toString()); //Print Fruit transaction list
    		System.out.println("Total :£" + checkOut.CalTotal()); //print the total value of the transaction list.
    		System.out.println( "--------------------------------------------------------------------------");
    }
	
	@Test
	public void test2()
    {
    		System.out.println( "--------------------------------------------------------------------------");
    		System.out.println("Transaction list:"+fruitTran.toString());
    		offer.put("Apple",new BuyOneGetOneFree());
    		checkOut.setOffer(offer);
    		System.out.println("Total :£" + checkOut.CalTotal());
    		System.out.println( "--------------------------------------------------------------------------");
    }
}
