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
        Message message = new Message();
        message.setText(" isso é uma mensagem");
        message.persist();

        Channel channel = new Channel();
        channel.setHash("123456");
        channel.addMessage(message);
        channel.persist();
        //cada um é um endpoint - user, message e channel --> tentar seprarar em 3 endpoints --> 3 métodos separados "public user create message, etc, procurar primerio o canal" --> método find faz isso pra gente
        User user = new User();
        user.setName(name);
        user.addChannel(channel);
        user.persist();
        

    
        //instanciar objetos aqui
        return user;
    }
    
}
