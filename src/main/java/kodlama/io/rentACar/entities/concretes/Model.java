package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="models") //brands table olduğunu belirttik.
@Getter
@Setter
@AllArgsConstructor //bizim icin parametreli constructor olusturur.
@NoArgsConstructor //parametresiz constructor oluşturur.
@Entity
//sen bir DB varlığısın , table olarak brands'e eş değersin . Senin getter setterların contructorların var demek.
public class Model {

    @Id //id verir uniqe olarak , alttaki anotation da otomatik verir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik artan bir değer olacak.
    @Column(name="id") //id kolonu brands tablosunda id kolonu ile eş değer.
    private int id;

    @Column(name="name") //name kolonu brands tablosunda name kolonu ile eş değer.
    private String name;


    @ManyToOne
    @JoinColumn(name="brand_id") //postgre tarafında olustururken _ ile ekliyor.// Bizim Model tablosunda brand_id kolonu bizim için koyacak. Ve bu brand_id ile brand arasında fiziksel bir ilişki kuracak.
    private Brand brand;

    @OneToMany (mappedBy = "model") //Model tablosunda model ile ilişkilendirildiğini belirttik. Car tablosundaki model alanı ile iişkilendir.
    private List<Car> cars; //bir modelin birden fazla aracı olabilir.


}
