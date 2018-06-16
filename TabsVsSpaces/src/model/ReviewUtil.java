package model;

import java.text.DecimalFormat;
import java.util.Map;

import bean.ReviewBean;

public class ReviewUtil {
	
	public static String calculateAvgBookRating(Map<Integer, ReviewBean> data) {
		float totalRating = 0;
		DecimalFormat df = new DecimalFormat("#.00"); 
		for(Map.Entry<Integer, ReviewBean> entry : data.entrySet()) {
			totalRating = totalRating + entry.getValue().getRating();
		}
		return df.format(totalRating/data.size());
	}
	
}
