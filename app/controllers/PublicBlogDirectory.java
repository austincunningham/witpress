package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;
import play.mvc.Controller;

public class PublicBlogDirectory extends Controller
{

  public static void index()
  {
    List<User> alluser =  User.findAll();
    render(alluser);
  }

}
