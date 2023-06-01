package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) // Belirsizlikleri yoksay, belirsizlik varsa ignore et
                .setMatchingStrategy(MatchingStrategies.LOOSE); //Belirli alanları maple
        return null;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD); // her şey maplensin
        return null;
    }
}
