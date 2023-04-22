package kodlama.io.rentACar.entities.concretes;

import lombok.Data;

@Data
public class Brand {
    private int id;
    private String name;

    public Brand(int id, String name){
        this.id=id;
        this.name=name;
    }

}

