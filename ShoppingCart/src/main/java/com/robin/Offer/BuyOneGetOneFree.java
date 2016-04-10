package com.robin.Offer;

public class BuyOneGetOneFree implements Offer {

	public int doCheckOut(int tCount) {
		float roundedValue=0; 
		try{
				if(tCount==0)
				{
					throw new IllegalArgumentException("The required quantity can't be Zero");
				}
				roundedValue= Math.round((double) tCount/2);
				System.out.println("Qty after Buy-One-Get-One offer:"+ (int) roundedValue);
			}
			catch(IllegalArgumentException e2)
			{
				System.out.println(e2.getMessage());
			}
		return (int) roundedValue;
		}
}
