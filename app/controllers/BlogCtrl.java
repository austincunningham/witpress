package controllers;

import play.*;
import play.mvc.*;


import java.util.*;
import models.*;

public class BlogCtrl extends Controller
{
  
  public static void index()
  {
    List<Post> posts = Post.findAll();
    render(posts);
  }

  public static void post(String Title, String Content)
  {
    Post post = new Post(Title, Content);
    Logger.info("Before Loop :"+post.Content+" "+post.Title+" "+post.id);
    post.save();
    List<Post> posts = Post.findAll();
    Logger.info("posts why -1 " +posts.indexOf(2));
    

    for(int i = 0;i>posts.size();i++)
    {
      
      //Logger.info("In loop post id :"+ posts[i].id +" Title :"+posts.Title+" Content :"+p.Content);
      posts.add(post);
      i++;
      Logger.info("end of Loop :"+post.Content+" "+post.Title+" "+post.id);
    }
    render("BlogCtrl/index.html", posts);
  }
/**
 * 
 */
  public static void deletePost(Post post)
  {
    post.delete();
    index();
  }
}
