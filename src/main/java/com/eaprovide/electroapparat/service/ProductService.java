package com.eaprovide.electroapparat.service;

import com.eaprovide.electroapparat.dto.product.ProductRequest;
import com.eaprovide.electroapparat.dto.product.ProductResponse;
import com.eaprovide.electroapparat.model.Product;
import com.eaprovide.electroapparat.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .nameId(productRequest.getNameId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .manufactory(productRequest.getManufactory())
                .categories(productRequest.getCategories())
                .subcategory(productRequest.getSubcategory())
                .price(productRequest.getPrice())
                .images(productRequest.getImages())
                .documentations(productRequest.getDocumentations())
                .build();

        productRepo.save(product);
        log.info("Product with {} is saved + product.getId()");
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> {
            return new RuntimeException("Product not found");
        });
        return mapToProductResponse(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
        log.info("Product with {} is deleted + id");
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(Long.valueOf(String.valueOf(product.getId())))
                .nameId(product.getNameId())
                .name(product.getName())
                .description(product.getDescription())
                .manufactory(product.getManufactory())
                .categories(product.getCategories())
                .subcategory(product.getSubcategory())
                .price(product.getPrice())
                .images(product.getImages())
                .documentations(product.getDocumentations())
                .build();
    }
}
