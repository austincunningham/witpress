package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class CommentCtrl extends Controller
{

  public static void index(Long id)
  {
    Post post = Post.findById(id);
    render();
  }

}