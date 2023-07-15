package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands") //brands table olduğunu belirttik.
@Getter
@Setter
@AllArgsConstructor //bizim icin parametreli constructor olusturur.
@NoArgsConstructor //parametresiz constructor oluşturur.
@Entity
//sen bir DB varlığısın , table olarak brands'e eş değersin . Senin getter setterların contructorların var demek.
public class Brand {

    @Id //id verir uniqe olarak , alttaki anotation da otomatik verir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik artan bir değer olacak.
    @Column(name = "id") //id kolonu brands tablosunda id kolonu ile eş değer.
    private int id;

    @Column(name = "name") //name kolonu brands tablosunda name kolonu ile eş değer.
    private String name;

    @OneToMany(mappedBy= "brand")//--> Model tablosunda brand ile ilişkilendirildiğini belirttik. Yani hangi alanla ilişkilendirdik.
    private List<Model> models;
}

