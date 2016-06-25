package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;


@Entity
public class Post extends Model
{
  @OneToMany(mappedBy = "posts", cascade=CascadeType.ALL)
  public List<Comment> comments = new ArrayList<Comment>();
  
  public String Title;
  public String Content;

  
  public Post(String Title, String Content)
  {
    this.Title = Title;
    this.Content = Content;
  }
}
