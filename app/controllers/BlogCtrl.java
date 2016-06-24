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
    post.save();
    Logger.info("Before Loop :"+post.Content+" "+post.Title+" "+post.id);
    List<Post> posts = Post.findAll();
    for(int i = 0;i>posts.size();i++)
    {
      posts.add(post);
      Logger.info("end of Loop :"+post.Content+" "+post.Title+" "+post.id);
    }
    index();
  }
/**
 * 
 */
  public static void deletePost(Long id)
  {
    Post post = Post.findById(id);
    post.delete();
    index();
  }
}
