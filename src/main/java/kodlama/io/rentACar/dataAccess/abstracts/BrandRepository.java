package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> { //BrandRepository ya da BrandDao olabilir.

    //TODO : //spring jpa keywords araştırılacak.
    boolean existsByName(String name);
}


//Bir interface diğer interface i extends eder.