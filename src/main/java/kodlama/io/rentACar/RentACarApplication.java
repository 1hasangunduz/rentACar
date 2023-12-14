package kodlama.io.rentACar;

import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.core.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice // Global exception handler oluşturmak için. Tüm controllerlar için geçerli olacak.
public class RentACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    //burası global exception handler. Tüm controllerlar için geçerli olacak. Kötü bir hata mesaji yerine daha güzek bir hata gösterecek.
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) { // BusinessException : İş kuralı hatası.
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("Validation.Exeption");
        validationProblemDetails.setValidationErrors(new HashMap<String,String>());

        //TODO : burası array olarak dönen mesajları map'e çevirmek için.sss
        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) { // BindingResult : Hata mesajlarını almak için.
            validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage()); // fieldError.getField() : hangi alanda hata var. fieldError.getDefaultMessage() : hata mesajı.
        }
        return validationProblemDetails;
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}

// dataAccess 'i Business kullanır, businessi Api kullanır. DataAccess->Business->API şeklinde hiyerarsi.





