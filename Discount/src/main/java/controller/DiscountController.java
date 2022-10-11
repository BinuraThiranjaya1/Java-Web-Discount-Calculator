package controller;

import model.DiscountModel;
import java.sql.ResultSet;
import database.DbConnection;

public class DiscountController {
	DiscountModel objDiscountModel;

	public DiscountController() {
		// bal = new courseAddAccessLogic();

	}

	public DiscountModel addCustomerId(int customerID) {
		objDiscountModel = new DiscountModel(customerID);
		return objDiscountModel;
	}

	public String getDiscountByID(DiscountModel Discount) {
		try {
			String query = "select * from customers where customer_code = " + Discount.getCustomerId();
			ResultSet rs = DbConnection.search(query);
			while (rs.next()) {
				String code = rs.getString("customer_code");
				return code;
				
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	public  int Discount(int Value,int Quantity) {
		return Value*Quantity;
	}
	public int findTimeSlotID(int Day) {
		try {
			String query = "SELECT * FROM `time_slots` WHERE '"+Day+"' BETWEEN `from` AND `to`";
			ResultSet rs = DbConnection.search(query);
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				return id;
				
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	
	}
	public  int findMaterialID(String material_group) {
		if (material_group.equals("emulsion")) {
			return 1;
		} else if (material_group.equals("enamal")) {
			return 2;

		} else if (material_group.equals("waterbase")) {
			return  3;
		} else {
			return -1;
		}
	}
	public int findValue(int timeSlot,int materialGroup) {
		try {
			String query = "SELECT `value` FROM `schema_detail` WHERE `time_slots`='"+timeSlot+"' AND`material_group`='"+materialGroup+"'";
			ResultSet rs = DbConnection.search(query);
			while (rs.next()) {
				int value = Integer.parseInt(rs.getString("value"));
				return value;
				
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}
}