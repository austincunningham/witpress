package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;


@Entity
public class Post extends Model
{
  public String Title;
  public String Content;

  
  public Post(String Title, String Content)
  {
    this.Title = Title;
    this.Content = Content;
  }
}
