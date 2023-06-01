package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
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
    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();

    }

    @PostMapping("/add")
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }


// IoC : Bellekte newleniyor onu veriyor bize . sürekli newlmek yerine , bellekte bir şeyi newle istiyene o refernansı ver.
    //Bir kere üret herkese onu ver.**
}

