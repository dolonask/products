package kg.megacom.products.models.dto;

import kg.megacom.products.models.entities.Category;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    Long id;

    String title;

    CategoryDto category;


}
