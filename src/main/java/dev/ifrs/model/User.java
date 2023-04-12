package dev.ifrs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User extends PanacheEntity {

    private String name;
    private String hash;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //name = nome da coluna que irá armazenar a chae estrangeira
    //na tabela Message

    @JoinColumn(name="user_id")
    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.ALL) 
    @JsonBackReference 
  
    private List<Channel> channels;

    public User(){
        this.channels = new ArrayList<>(); 
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }   
    
}
