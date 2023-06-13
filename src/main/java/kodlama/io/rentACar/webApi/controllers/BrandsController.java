package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands") //tarayicidaki adreslemedeki gördüğümüz uzanti.
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

/*
    //@Autowired //Git parametrelerine bak, kim implemente ediyorsa onu bul. (Yeni sürümlerde Autowired olmadan da calışıyor.)
    public BrandsController(BrandService brandService) {
        super();
        this.brandService = brandService;
    }
    buraları lombok ile yaptık. AllArgsConstructor
*/


    //www.hasangunduz.com/api/brands/getAll diyoruz ya gel bu methodu çalıştır demek.
    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();

    }

    @GetMapping("/{id}")
    //api/brands/getById/1  , @PathVariable : parametre olarak gelen id'yi al. {id} : variable olarak al.
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }


    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

// IoC : Bellekte newleniyor onu veriyor bize . sürekli newlmek yerine , bellekte bir şeyi newle istiyene o refernansı ver.
    //Bir kere üret herkese onu ver.**
}

