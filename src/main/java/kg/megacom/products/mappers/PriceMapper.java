package kg.megacom.products.mappers;


import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.models.dto.PriceDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends CrudMapper<Price, PriceDto> {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price productRequestToPrice(ProductRequest productRequest);

    PriceDto toPriceDto(Price price);

}
