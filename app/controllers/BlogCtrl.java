package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class BlogCtrl extends Controller
{
  public static void index()
  {
    render();
  }

  public static void post()
  {
    //Blog blog = new Blog(User from, String Title, String Content);
    render();
  }
/**
 * clears the session id
 */
  public static void deletePost()
  {
    
    //blog.delete();
    index();
  }
  
  public static Blog getCurrentPost()
  {
    
    String id = " ";
    Blog selectedPost = Blog.findById(id);
    Logger.info("selected Post: " + selectedPost.Title);
    return selectedPost;
  }
}
