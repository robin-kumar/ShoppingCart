package com.robin.Offer;

public class ThreeForPriceOfTwo implements Offer {

	public int doCheckOut(int tCount) {
		int count=0;
		try{
			if(tCount<=0){
				throw new IllegalArgumentException("The required quantity can't be Zero");
			}
			for(;tCount >=3;count+=2,tCount-=3);
			count+= tCount==0?0:tCount;
			System.out.println("Qty after Three-For-Price-Of-Two offer:"+ count);
		}
		catch(IllegalArgumentException e3)
		{
			System.out.println(e3.getMessage());
		}
		return count;
	}
}
