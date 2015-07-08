package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.RawSchema;
import play.*;
import play.mvc.*;
import views.html.index;

public class Schemas extends Controller  {
    public Result index() {
    	RawSchema rs=new RawSchema();
    	
    	//return ok(play.libs.Json.toJson(ls1)); //Works! 
        return ok(views.html.schemas.render(rs.GetAllSchemasList(), rs.GetXML()));
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
    
    public Result xmlRawSchema(String schemaName, String server) {
    	
    	//File f = new File("C:/workspace/XMLFile/Event.xml");
    	String s="";
		try {
			File file = new File("C:/workspace/XMLFile/Event.xml");
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