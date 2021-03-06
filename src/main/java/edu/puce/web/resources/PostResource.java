package edu.puce.web.resources;

 

 

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

 

import edu.puce.web.entities.Post;
import edu.puce.web.repositories.PostRepository;

 

@RequestScoped
@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {
    
    @Inject
    PostRepository postRepository;

 

    @GET
    public Response getAllPosts() {
        return Response.ok().entity(postRepository.getAllPosts()).build();
    }
    
    @GET
    @Path("{id}")
    public Response getPostById(@PathParam("id") Long id) {
        return Response.ok().entity(postRepository.findById(id)).build();
    }
    
    @POST
    public Response create(Post post, @Context UriInfo uriInfo) {
        Post postId = postRepository.create(post);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Long.toString(postId.getId()));
        return Response.created(builder.build()).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Post post) {
        Post updatePost = postRepository.findById(id);
        
        updatePost.setAuthor(post.getAuthor());
        updatePost.setName(post.getName());
        
        return Response.ok().entity(post).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("{id}") Long id) {
        Post post = postRepository.findById(id);
        postRepository.delete(post);
        return Response.noContent().build();
    }
    
        
    
}