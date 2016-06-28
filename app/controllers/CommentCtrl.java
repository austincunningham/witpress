package controllers;

import play.*;
import play.db.jpa.GenericModel;
import play.mvc.*;

import java.util.*;

import models.*;

public class CommentCtrl extends Controller
{

  public static void index(Long id)
  {
    Post post = Post.findById(id);
    //List<Comment> currentComments =  Comment.findAll();
    render(post , post.comments);
  }

  public static void post(Long id, String Comments)
  {
    Post post = Post.findById(id);
    Comment com = new Comment(Comments);
    com.save();
    Logger.info("Comment id: "+ com.id + " Post id: "+post.id);
    post.commentAdd(com);
    index(id);
  }
}