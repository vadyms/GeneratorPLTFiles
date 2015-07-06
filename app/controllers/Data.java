package controllers;

import java.util.ArrayList;
import java.util.List;

import data.RawSchema;
import play.*;
import play.mvc.*;
import views.html.index;

public class Data extends Controller  {
    public Result index() {
    	Data dt=new Data();
        return ok(views.html.data.render("Hi"));
    }
}