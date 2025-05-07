package ma.smartMenu.smartmenu.web;

import ma.smartMenu.smartmenu.dto.ProductCategoryDto;
import ma.smartMenu.smartmenu.dto.ProductCategoryResponseDto;
import ma.smartMenu.smartmenu.model.ProductCategory;
import ma.smartMenu.smartmenu.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/categories")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * This function allows to get all products categories
     * @return {List<ProductCategory>} List of categories
     */
    @GetMapping("")
    public List<ProductCategoryResponseDto> getAllCategories(){
        return  this.productCategoryService.getAllCategories();
    }

    /**
     * This function allows to get product category bt id
     * @param category_id product category id
     * @return {ProductCategory} Product category
     */
    @GetMapping("/{category_id}")
    public Optional<ProductCategory> getAllCategories(@PathVariable Long category_id){
        return  this.productCategoryService.getCategoryById(category_id);
    }

    /**
     * This function allows us to create a new product category
     * @param productCategoryDto info to crate a new product category
     * @return {ProductCategory} The created Product category
     */
    @PostMapping("")
    public ProductCategory createNewCategory(@RequestBody  ProductCategoryDto productCategoryDto){
        return this.productCategoryService.saveProductCategory(productCategoryDto);
    }
}
