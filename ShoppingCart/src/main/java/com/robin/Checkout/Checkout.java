package com.robin.Checkout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.robin.Offer.Offer;

public class Checkout {
	Map<String,Fruit> StockFruit = null;// Acts as Fruit Master
	List<String> tranFruit= null;//used to hold the Transaction details 
	List<TranList> tList = null; // used to calculate hold item and item count
	Map<String,Offer> offer =null; // use to hold existing offer
	
	public void setStockFruit(Map<String, Fruit> stockFruit) {
		StockFruit = stockFruit;
	}
	public void setTranFruit(List<String> tranFruit) {
		this.tranFruit = tranFruit;
	}
	public void settList(List<TranList> tList) {
		this.tList = tList;
	}
	public void setOffer(Map<String,Offer> offer)
	{
		this.offer=offer;
	}
	
	/**
	 * Calculates the total cost of the fruits selected
	 * @return total cost
	 */
	public double CalTotal()
	{
		double total=0;
		int cnt=0;
		DecimalFormat format = new DecimalFormat("##.00");//for formating the output to two decimal positions
		Fruit tempFruit=null;
		try{
			
		if(tranFruit == null)
		{
			throw new IllegalArgumentException("No Transaction found");
		}
		Collections.sort(tranFruit);
		buildItemsList();// for calculating Fruit-wise-count
		for(TranList tempTran:tList)
		{
			tempFruit = StockFruit.get(tempTran.gettItem());
			cnt=tempTran.gettQty();
			System.out.println(tempFruit.getDesc()+" qty:"+ cnt);
			if(offer != null)
			{
				Offer tempOffer =offer.get(tempTran.gettItem());
				if(tempOffer != null)
				{cnt=tempOffer.doCheckOut(cnt);}
			}
			if(cnt>0)
			{
				System.out.println(cnt+" * "+tempFruit.getPrice()+ "="+ format.format((double)cnt*tempFruit.getPrice()));
				total+=cnt*tempFruit.getPrice();//total calculation
				cnt=0;
			}
			else
			{
				System.out.println(" Qty is zero or less than zero ");
			}
			
		}
		}
		catch(IllegalArgumentException e1){
			System.out.println(e1.getMessage());
		}
		return total;
	}
/**
 * Method to calculate Fruit wise count
 */
private void buildItemsList()
{
	tList = new ArrayList<TranList>();
	TranList temp = null;
	int count =0;
	String mValue = tranFruit.get(0);//to get the first value
	for(String tempName:tranFruit)
	{
		if(!mValue.equals(tempName))
		{
			temp = new TranList(mValue,count);
			tList.add(temp);
			mValue =tempName;
			count=0;
		}
		else
		{
			count++;
		}
	}
	temp = new TranList(mValue,++count);
	tList.add(temp);
}
	

}
