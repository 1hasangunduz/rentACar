package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepositroy extends JpaRepository<Model, Integer> {

}
