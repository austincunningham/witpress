package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class PublicBlog extends Controller
{

  public static void index(long id)
  {
    User currentUser = User.findById(id);
    List<Post> allPosts = Post.findAll();
    List<Post> userPosts = new ArrayList<Post>();
    for(Post post : allPosts)
    {
      if (post.sourceUser.id == currentUser.id)
      {
        userPosts.add(post);
      }
    }
    
    render(currentUser, userPosts);
  }

}