package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //sen bir DB varlığısın , table olarak brands'e eş değersin . Senin getter setterların contructorların var demek.
@Table(name="brands") //brands table olduğunu belirttik.
@Data
@AllArgsConstructor //bizim icin parametreli constructor olusturur.
@NoArgsConstructor //parametresiz constructor oluşturur.
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik artan bir değer olacak.
    @Column(name="id") //id kolonu brands tablosunda id kolonu ile eş değer.
    private int id;

    @Column(name="name") //name kolonu brands tablosunda name kolonu ile eş değer.
    private String name;


}

