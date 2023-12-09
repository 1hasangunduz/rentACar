package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepositroy;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//bu class servis görevi görecek demek. Spring'e bu class'ı servis olarak tanımladık. Spring bu class'ı new'leyecek. Spring bu class'ı new'lediğinde bu class'ın constructor'ını çalıştıracak.
@AllArgsConstructor //constructor'ı oluşturuyor. ekstradan const yapamaya gerek kalmıyor.
public class ModelManager implements ModelService {

    private ModelRepositroy modelRepositroy;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepositroy.findAll();

        return models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).toList();
    }

    @Override
    public void add(CreateModelRequest createModelRequest) { //CreateModelRequest ile gelen verileri Model'e çevirip veritabanına kaydediyoruz.
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class); //map metodu ile createModelRequest'i Model'e çeviriyoruz.
        this.modelRepositroy.save(model); //save metodu ile veritabanına kaydediyoruz.
    }


}







