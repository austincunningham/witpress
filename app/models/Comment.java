package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;



@Entity
public class Comment extends Model
{  
  @ManyToOne
  public Post blogComment;
  
  public String content;
  
  public Comment(String content,Post blogComment)
  {
    this.content = content;
    this.blogComment = blogComment;
  }
}