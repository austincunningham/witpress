package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class About extends Controller
{

  public static void index()
  {
    User currentUser = Accounts.getCurrentUser();
    render(currentUser);
  }

}