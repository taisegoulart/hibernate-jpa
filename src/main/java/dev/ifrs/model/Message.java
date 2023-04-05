package dev.ifrs.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Message extends PanacheEntity {
    private String text;
}
