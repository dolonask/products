package kg.megacom.products.controllers;

import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.dto.responses.ProductResponse;
import kg.megacom.products.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ProductResponse save(@RequestBody ProductRequest productRequest){
        return productService.save(productRequest);
    }
}
