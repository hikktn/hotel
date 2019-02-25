package com.lisonglin.daomain;

public class Bed {
	private int id;
	private int number;
	private double width;
	private String bed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	@Override
	public String toString() {
		return "Bed [id=" + id + ", number=" + number + ", width=" + width + ", bed=" + bed + "]";
	}

}
