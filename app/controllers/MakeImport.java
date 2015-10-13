package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import data.RawSchema;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.index;
import play.mvc.Http.RequestBody;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MakeImport extends Controller  {

	private String sDate="";
	private int count=0;
	private String sStatFile="stat.log";
	private String sPage="MakeImport";
	
	private void statistic(String page, int count) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
 	   	//get current date time with Date()
 	   	Date date = new Date();
 	   	//get current date time with Calendar()
 	   	Calendar cal = Calendar.getInstance();
 	   	
    	if (sDate.equals(dateFormat.format(date))) {
    	} else {
    		sDate = dateFormat.format(date);
    		count=1;
    	}
 	   	
    	List<String> lines = new ArrayList<String>();
    	try {
	    	BufferedReader reader = new BufferedReader(new FileReader(sStatFile));
	    	String line;
	    	while ((line = reader.readLine()) != null) {
	    		lines.add(line);
	    	}
	    	reader.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}

    	boolean bFound=false;
    	for(int i=0;i<lines.size();++i){
    		if (lines.get(i).contains(sDate+ " - "+sPage)) {
    			lines.set(i,sDate+" - "+page+" - "+Integer.toString(count));
    	    	bFound=true;
    		}
    	}
    	if (!bFound) {
    		lines.add(sDate+" - "+page+" - "+Integer.toString(count));
    	}
    	try {
			FileWriter writer = new FileWriter(sStatFile); 
			for(String str: lines) {
			  writer.write(str+"\n");
			}
			writer.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
    public Result index() {
    	// save statistic
    	Logger.info("MakeImport - "+request().remoteAddress());
    	String path = request().path();
    	count++;
    	statistic(sPage,count);
    	
    	RawSchema rs=new RawSchema();
        return ok(views.html.makeimport.render(rs.GetAllSchemasList(), rs.GetXML(),rs.GetAllSchemasList(),rs.GetAllSchemasList()));
    }
    
    public String schemas(String schema) {
    	RawSchema rs=new RawSchema();
    	//return ok(play.libs.Json.toJson(ls1)); //Works! 
        return rs.GetSchema(rs.GetSchema("test"));
    }
    
    public Result test() {

        return ok("test");
    }
    public Result lsSchemas() {
    	RawSchema rs=new RawSchema();
    	return ok(rs.GetAllSchemasList().toString());
    }
    
    public Result compareData() {
        DynamicForm form = Form.form().bindFromRequest();

        if (form.data().size() == 0) {
            return badRequest("Expceting some data");
        } else {
            String response1 = "Client " + form.get("foo") + "has phone number " + form.get("telefone_cliente");

            //return ok(response1,response2,response3);
            return ok(response1);
        }
    }
    public Result xmlRawSchema(String schemaName, String server) {
    	//File f = new File("C:/workspace/XMLFile/Event.xml");
    	String s="";
		try {
			File file = new File("C:/workspace/XMLFile/SprintSessionIVRRawData_tiny.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			s=stringBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //return ok(f+"!"+schemaName+"-"+server+"!");
    	//return ok(f.toString());
    	return ok(s);
    }
}