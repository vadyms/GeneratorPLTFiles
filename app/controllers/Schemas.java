package controllers;

import java.io.File;
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
    	File f = new File("C:/workspace/XMLFile/Event.xml");
//        BufferedReader reader = new BufferedReader( new FileReader ("C:/workspace/XMLFile/Event.xml"));
//        String         line = null;
//        StringBuilder  stringBuilder = new StringBuilder();
//        String         ls = System.getProperty("line.separator");
//
//        while( ( line = reader.readLine() ) != null ) {
//            stringBuilder.append( line );
//            stringBuilder.append( ls );
//        }
//        //return ok(f+"!"+schemaName+"-"+server+"!");
    	return ok(f.toString());
    }

}