package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.Logger;
import play.db.jpa.Model;


@Entity
public class Post extends Model
{
  //@OneToMany(mappedBy = "blog",cascade=CascadeType.ALL)
 @OneToMany(cascade=CascadeType.ALL)
 public static List<Comment> comments;
  
  public String Title;
  public String Content;

  
  public Post(String Title, String Content)
  {
    this.Title = Title;
    this.Content = Content;
    this.comments = new ArrayList<Comment>();
  }
  
  public void commentAdd(Comment comment)
  {
    comments.add(comment);
    int i = 0;
    for(Comment c: comments)
    { 
      Logger.info("comments list :"+ c.comments );
      i++;
    }
  }
}
