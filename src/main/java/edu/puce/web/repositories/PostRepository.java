package edu.puce.web.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.puce.web.entities.Post;


@Stateless
public class PostRepository {

    @PersistenceContext(unitName = "Persistence")
    EntityManager em;
    
    //crud de la pojo o tabla
    
    @SuppressWarnings("rawtypes")
    public List getAllPosts() {
        return em.createNamedQuery("Post.findAll",Post.class).getResultList();
    }
    
    public Post findById(Long id) {
        return em.find(Post.class, id);
    }
    
    public Post create (Post post) {
        em.persist(post);
		return post;
    }

 

    public void update (Post post) {
        em.merge(post);
    }
    public void delete(Post post) {
        if(!em.contains(post)) {
            post = em.merge(post);
        }
        em.remove(post);
    }
    
    
}