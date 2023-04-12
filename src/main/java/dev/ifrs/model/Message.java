package dev.ifrs.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Message extends PanacheEntity {

    private String text;
    //declaração implicita do id quando colocamos o Panache Entity

/*     public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    } */ 

    //por que raios tem isso aqui em cima, se tem o lombok?

}
