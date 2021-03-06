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
  @OneToMany(mappedBy = "blogComment", cascade=CascadeType.ALL)
  //@OneToMany(cascade = CascadeType.ALL)
  public List<Comment> comments  = new ArrayList<Comment>();
  
  @ManyToOne
  public User sourceUser;

  public String title;
  public String content;

  public Post(String title, String content, User sourceUser)
  {
    this.title = title;
    this.content = content;
    this.sourceUser = sourceUser;
  }

  public void commentAdd(Comment com)
  {
    comments.add(com);
    int i = 0;
    for (Comment c : comments)
    {
      Logger.info("comments list :" + c.content);
      i++;
    }
  }
}
