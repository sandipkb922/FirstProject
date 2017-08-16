package RetailerTransanction;

import java.util.Date;

import product.Footware;

public class TransanctionRecord {
	private String retailerName = null;
	private int orderCount = 0;
	private int remainingCount = 0;
	private Footware orderObject = null;
	private Date orderDate = null;
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate() {
		this.orderDate = new Date();
	}
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getRemainingCount() {
		return remainingCount;
	}
	public void setRemainingCount(int remainingCount) {
		this.remainingCount = remainingCount;
	}
	public Footware getOrderObject() {
		return orderObject;
	}
	public void setOrderObject(Footware orderObject) {
		this.orderObject = orderObject;
	}
	@Override
	public String toString() {
		return "[retailerName=" + retailerName + ", orderCount=" + orderCount + ", remainingCount="
				+ remainingCount + ", orderDate=" + orderDate + ", orderObject=" + orderObject + "]\n";
	}
		
}
