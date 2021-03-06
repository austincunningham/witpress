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
    User currentUser = Accounts.getCurrentUser();
    Post post = Post.findById(id);
    //List<Comment> currentComments =  Comment.findAll();
    render(post , post.comments,currentUser);
  }

  public static void post(Long id, String Comments)
  {
    Post post = Post.findById(id);
    Comment com = new Comment(Comments, post);
    com.save();
    Logger.info("Comment id: "+ com.id + " Post id: "+post.id+" anything here? "+com.blogComment);
    post.commentAdd(com);
    index(id);
  }
  public static void deleteComment(Long id)
  {
    //Post post = Post.findById(postId);
    Comment comment = Comment.findById(id);
    comment.delete();
    index(comment.blogComment.id);
  }
  
}