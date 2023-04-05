package dev.ifrs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User extends PanacheEntity {

    private String name;

    @ManyToMany    
    private List<Channel> channels;

    public User(){
        this.channels = new ArrayList<>(); 
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    
    
}
