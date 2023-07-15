package kodlama.io.rentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cars") //cars table olduğunu belirttik.
@Getter
@Setter
@AllArgsConstructor //bizim icin parametreli constructor olusturur.
@NoArgsConstructor //parametresiz constructor oluşturur.
@Entity
public class Car {

    @Id //id verir uniqe olarak , alttaki anotation da otomatik verir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik artan bir değer olacak.
    @Column(name = "id") //id kolonu cars tablosunda id kolonu ile eş değer.
    private int id;

    @Column(name = "plate", unique = true) //unique = true --> plaka benzersiz olmalı. constraint koyar uniqe kısıtı.
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state; // 1: Available, 2: Rented , 3: Maintenance

    @ManyToOne //çoklu bir ilişki var demek.
    @JoinColumn(name = "model_id")
    //postgre tarafında olustururken _ ile ekliyor.// Bizim Model tablosunda model_id kolonu bizim için koyacak. Ve bu model_id ile model arasında fiziksel bir ilişki kuracak.
    private Model model;


}
