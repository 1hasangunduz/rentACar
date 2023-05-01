package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands") //tarayicidaki adreslemedeki gördüğümüz uzanti.
public class BrandsController {

    private BrandService brandService;

    @Autowired //Git parametrelerine bak, kim implemente ediyorsa onu bul. (Yeni sürümlerde Autowired olmadan da calışıyor.)
    public BrandsController(BrandService brandService) {
        super();
        this.brandService = brandService;
    }


    //www.hasangunduz.com/api/brands/getAll diyoruz ya gel bu methodu çalıştır demek.
    @GetMapping("/getall")
    public List<Brand> getAll(){
        return brandService.getAll();

    }


// IoC : Bellekte newleniyor onu veriyor bize . sürekli newlmek yerine , bellekte bir şeyi newle istiyene o refernansı ver.
    //Bir kere üret herkese onu ver.**
}
