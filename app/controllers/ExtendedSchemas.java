package controllers;

import java.util.ArrayList;
import java.util.List;

import data.RawSchema;
import play.*;
import play.mvc.*;
import views.html.index;

public class ExtendedSchemas extends Controller  {
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
}