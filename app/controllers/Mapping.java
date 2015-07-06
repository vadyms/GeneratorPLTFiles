package controllers;

import data.RawSchema;
import play.mvc.Controller;
import play.mvc.Result;

public class Mapping  extends Controller{
    public Result index() {
    	//return ok(play.libs.Json.toJson(ls1)); //Works! 
        return ok("Mapping controller");
    }
}
