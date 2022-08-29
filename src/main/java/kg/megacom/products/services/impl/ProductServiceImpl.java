package kg.megacom.products.services.impl;

import kg.megacom.products.dao.ProductRepo;
import kg.megacom.products.mappers.ProductMapper;
import kg.megacom.products.models.dto.PriceDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.dto.responses.ProductResponse;
import kg.megacom.products.models.entities.Product;
import kg.megacom.products.services.CategoryService;
import kg.megacom.products.services.PriceService;
import kg.megacom.products.services.ProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {


    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final ProductRepo productRepo;
    private final PriceService priceService;

    public ProductServiceImpl(CategoryService categoryService, ProductRepo productRepo, PriceService priceService) {
        this.categoryService = categoryService;
        this.productRepo = productRepo;
        this.priceService = priceService;
        this.productMapper = ProductMapper.INSTANCE;
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {

        Product product = productMapper.productRequestToProduct(productRequest);

        categoryService.checkExistsByIdAndActive(product.getCategory().getId());

        product = productRepo.save(product);

        PriceDto priceDto = priceService.save(productRequest, product);


        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(productMapper.toDto(product));

        



        return null;
    }
}
