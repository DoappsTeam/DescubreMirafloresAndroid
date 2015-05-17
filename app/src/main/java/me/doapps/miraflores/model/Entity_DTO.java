package me.doapps.miraflores.model;

/**
 * Created by jonathan on 17/05/2015.
 */
public class Entity_DTO {
    private String name;

    public Entity_DTO(){}

    public Entity_DTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
