package kodlama.io.rentACar.business.rules;


import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // Constructor injection yapabilmek için.
public class BrandBusinessRules {


    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name) {  // checkIfBrandNameExists : marka ismi tekrar ediyor mu?
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists!");
        }
    }


}
