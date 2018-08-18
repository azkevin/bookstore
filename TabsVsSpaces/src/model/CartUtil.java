package model;

import java.text.DecimalFormat;
import java.util.Map;

import bean.CartBean;

public class CartUtil {
	public static String calculateTotalPrice(Map<Integer, CartBean> data) {
		float totalRating = 0;
		DecimalFormat df = new DecimalFormat("#.00"); 
		for(Map.Entry<Integer, CartBean> entry : data.entrySet()) {
			totalRating = totalRating + entry.getValue().getPrice();
		}
		return df.format(totalRating);
	}
}
