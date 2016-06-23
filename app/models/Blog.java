package models;
import javax.persistence.Entity;
import play.db.jpa.Model;
import javax.persistence.Entity;

@Entity
public class Blog extends Model
{
  private User from;
  public String Title;
  private String Content;

  public Blog(User from,String Title, String Content)
  {
    this.from = from;
    this.Title = Title;
    this.Content = Content;
  }
}
