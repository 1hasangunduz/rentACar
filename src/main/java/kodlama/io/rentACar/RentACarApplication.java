package kodlama.io.rentACar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Swagger'ı başlatan anotasyon
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

}

// dataAccess 'i Business kullanır, businessi Api kullanır. DataAccess->Business->API şeklinde hiyerarsi.
