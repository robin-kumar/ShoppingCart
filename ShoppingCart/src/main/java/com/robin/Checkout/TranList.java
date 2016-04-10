package com.robin.Checkout;

public class TranList {
	String tItem;
	int tQty;
	
	// Constructor to set Item and total Qty
	public TranList(String tItem, int tQty) {
		super();
		this.tItem = tItem;
		this.tQty = tQty;
	}

	public String gettItem() {//getter for Item desc
		return tItem;
	}

	public int gettQty() { //getter for Total qty
		return tQty;
	}

	public void settItem(String tItem) {//setter for Item Desc
		this.tItem = tItem;
	}

	public void settQty(int tQty) {//setter for Total qty
		this.tQty = tQty;
	}

	@Override
	public String toString() {
		return "TranList [tItem=" + tItem + ", tQty=" + tQty + "]";
	}
	
	

}
