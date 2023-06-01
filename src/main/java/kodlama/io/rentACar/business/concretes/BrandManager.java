package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sınıf bir business nesnesidir. otomatik olarak bir service katmanı olarak newlenecek.
@AllArgsConstructor
public class BrandManager implements BrandService {


    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
         /*List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);
        }*/

        //Aşağıdaki for each'in yaptığını yapar. Yukarıdaki kodun görevini üstlenir her seferinde gelip set yamaya gerek kalmaz.
        // aşağıdaki yapı REFLECTİONDUR.
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();

        //Business kurallarını yazıcaz
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }
}
