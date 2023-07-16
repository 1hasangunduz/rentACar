package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @NotBlank
    private int brandId;

}

//TODO: Entity nedir?
//Entity veritabanımız ile yazılımımız arasında ilişki kurmamızı sağlayan kalıcı nesneler olarak tanımlanabilir. Java da POJO sınıfları birer Entity'dir.
// Java Persistence API, Entity üzerine kurulmuştur.
// Entityler veritabanına eklenebilir / silinebilir / güncellenebilir özelliktedirler.