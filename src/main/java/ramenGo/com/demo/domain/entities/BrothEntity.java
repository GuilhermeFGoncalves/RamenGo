package ramenGo.com.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class BrothEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private Integer price;


    public BrothEntity(String imageInactive, String imageActive, String name, String description, Integer price) {
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public BrothEntity() {
    }
}
