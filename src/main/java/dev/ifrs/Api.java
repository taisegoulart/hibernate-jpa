package dev.ifrs;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Channel;
import dev.ifrs.model.Message;
import dev.ifrs.model.User;

@Path("/user")
public class Api {
    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional

    public User createUser(@FormParam("name") String name){

        //Não faça isso na vida real! Do ponto de vista de arquitetura, isso está errado.
        Channel channel = new Channel();
        channel.setHash("aaaa");
        channel.persist();

        User user = new User();
        user.setName(name);
        user.addChannel(channel);
        user.persist();
        return user;


    }
    
}
