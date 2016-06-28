package controllers;

import play.*;
import play.mvc.*;


import java.util.*;
import models.*;

public class BlogCtrl extends Controller
{
  
  public static void index()
  {
    User currentUser = Accounts.getCurrentUser();
    List<Post> posts = Post.findAll();
    List<Post> currentUserPosts = new ArrayList<Post>();
    for(Post post: posts)
    {
      if (post.sourceUser.id == currentUser.id)
      {
        currentUserPosts.add(post);
      }
    }
    render(currentUserPosts);
  }

  public static void post(String title, String content)
  {
    User sourceUser = Accounts.getCurrentUser();
    Post post = new Post(title, content, sourceUser);
    post.save();
    Logger.info("Before Loop :"+post.content+" "+post.title+" "+post.id+" "+sourceUser.firstName);
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
