package ma.smartMenu.smartmenu.service;

import ma.smartMenu.smartmenu.dto.ProductCategoryDto;
import ma.smartMenu.smartmenu.dto.ProductCategoryResponseDto;
import ma.smartMenu.smartmenu.model.ProductCategory;
import ma.smartMenu.smartmenu.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    public List<ProductCategoryResponseDto> getAllCategories(){
        List<ProductCategory> categories = this.productCategoryRepository.findAll();
        return categories.stream()
                .map(ProductCategoryResponseDto::new)
                .collect(Collectors.toList());
    }



    public Optional<ProductCategory> getCategoryById(Long category_id){
        return this.productCategoryRepository.findById(category_id);
    }

    public ProductCategory saveProductCategory(ProductCategoryDto productCategoryDto){
        return productCategoryRepository.save(
                ProductCategory.builder()
                        .name(productCategoryDto.name)
                        .icon(productCategoryDto.icon)
                        .ref(UUID.randomUUID())
                        .description(productCategoryDto.description)
                        .build()
        );
    }


}
