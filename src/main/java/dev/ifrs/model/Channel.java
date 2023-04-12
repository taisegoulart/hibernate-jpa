package dev.ifrs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference; //isso aqui serve para relacionamento bidirecional: na hora de criar o JSON (não tem nada a ver com o mapeamento do banco!), quando quero pegar infromações de um usuário, usuário tem id e nome, mas ele tbm tem uma lsita de canais,. quando chego no canal preciso recuperar os usuários, ele fica num loop infinito pois um usuário tem váriso canais e canais tem vários usuários --no material do profe isso é na parte do Json Binding, essas anotações servem apra cortar esse loop infinito
import lombok.Getter;
import lombok.Setter;
//ws é os webservices
@Entity
@Getter @Setter
public class Channel extends PanacheEntity{

    private String hash;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
    private List<User> users;

    public Channel(){
        this.users = new ArrayList<>(); 
    }

    public void addUser(User user){
        this.users.add(user);
    }
    
}
