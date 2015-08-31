package lib;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class action {
	private List<String> visitors = new ArrayList<String>();
	private String sVisitorList="VisitLog.log";
	
	public void visitors(String remote) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 	   	//get current date time with Date()
 	   	Date date = new Date();
 	   	//get current date time with Calendar()
 	   	Calendar cal = Calendar.getInstance();
 	   	String sDate = dateFormat.format(date);
 	   	
		visitors.add(sDate+ " - "+remote+"\n");
		
    	try {
			FileWriter writer = new FileWriter(sVisitorList); 
			for(String str: visitors) {
			  writer.write(str);
			}
			writer.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
