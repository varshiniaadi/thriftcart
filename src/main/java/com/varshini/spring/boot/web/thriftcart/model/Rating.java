package com.varshini.spring.boot.web.thriftcart.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rating {
	 private double rate;
	   private int count;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
