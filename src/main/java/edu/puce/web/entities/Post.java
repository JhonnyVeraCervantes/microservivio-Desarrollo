package edu.puce.web.entities;
import java.io.Serializable;
import javax.persistence.*;

 

@Entity
@Table(name="posts")
@NamedQueries({
    @NamedQuery(name="Post.findAll", query = "SELECT p FROM Post p")
})
public class Post implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="name", length = 255)
    private String name;
    
    @Column(name="author", length = 255)
    private String author;

 

    public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }

 

    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public String getAuthor() {
        return author;
    }

 

    public void setAuthor(String author) {
        this.author = author;
    }

 

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    

 

}