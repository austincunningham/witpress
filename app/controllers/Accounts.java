package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Accounts extends Controller
{

  public static void signup()
  {
    User currentUser = Accounts.getCurrentUser();
    render(currentUser);
  }

  public static void login()
  {
    User currentUser = Accounts.getCurrentUser();
    render(currentUser);
  }
/**
 * clears the session id
 */
  public static void logout()
  {
    session.clear();
    About.index();
  }
/**
 * parma passed from form in Accounts/signup.html to model User to populate DB
 * @param firstName
 * @param lastName
 * @param email
 * @param password
 */
  public static void register(String firstName, String lastName, String email, String password)
  {
    Logger.info(firstName + " " + lastName + " " + email + " " + password);
    User user = new User(firstName, lastName, email, password);
    user.save();
    login();

  }
/**
 * compares param with DB to authenticate
 * @param email
 * @param password
 */
  public static void authenticate(String email, String password)
  {
    Logger.info("Attempting to authenticate with " + email + ":" + password);
    User user = User.findByEmail(email);
    if ((user != null) && (user.checkPassword(password) == true))
    {
      Logger.info("Authentication successful");
      session.put("logged_in_userid", user.id);
      BlogCtrl.index();
    }
    else
    {
      Logger.info("Authentication failed");
      login();
    }
  }
/**
 * Checks session id for current user id
 * @return
 */
  public static User getCurrentUser()
  {
    String userId = session.get("logged_in_userid");
    if (userId == null)
    {
      return null;
    }
    User logged_in_user = User.findById(Long.parseLong(userId));
    Logger.info("Logged in User: " + logged_in_user.firstName);
    return logged_in_user;
  }

}