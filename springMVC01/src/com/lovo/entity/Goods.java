package com.lovo.entity;

public class Goods {

	private String gname;
	private double price;

	public Goods() {

	}

	public Goods(String gname, double price) {
		this.gname = gname;
		this.price = price;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [gname=" + gname + ", price=" + price + "]";
	}

}
