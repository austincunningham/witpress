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

  public static void post(String title, String content)
  {
    Post post = new Post(title, content);
    post.save();
    Logger.info("Before Loop :"+post.content+" "+post.title+" "+post.id);
    List<Post> posts = Post.findAll();
    for(int i = 0;i>posts.size();i++)
    {
      posts.add(post);
      Logger.info("end of Loop :"+post.content+" "+post.title+" "+post.id);
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
