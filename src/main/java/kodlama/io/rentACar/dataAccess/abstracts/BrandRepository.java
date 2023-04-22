package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository { //BrandRepository ya da BrandDao olabilir.

   List<Brand> getAll();



}
