package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class CopyOfCompare extends Controller  {
    public Result index() {
    	RawSchema rs=new RawSchema();
    	
    	//return ok(play.libs.Json.toJson(ls1)); //Works! 
        return ok(views.html.compare.render(rs.GetAllSchemasList(), rs.GetXML(),rs.GetAllSchemasList(),rs.GetAllSchemasList()));
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