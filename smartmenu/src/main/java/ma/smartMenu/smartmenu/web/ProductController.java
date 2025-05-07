package ma.smartMenu.smartmenu.web;

import ma.smartMenu.smartmenu.dto.ProductDto;
import ma.smartMenu.smartmenu.dto.ProductResponseDto;
import ma.smartMenu.smartmenu.model.Product;
import ma.smartMenu.smartmenu.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /**
     * This function allows us to get all products
     * @return {Product}
     */
    @GetMapping("")
    public List<ProductResponseDto> getAllProducts(){

        return productService.getAllProducts();
    }

    /**
     * This function allows us to get a product by id
     * @param id The id of product
     * @return {Product}
     */
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }


    @GetMapping("/ref/{product_ref}")
    public Optional<ProductResponseDto> getProductByRef(@PathVariable UUID product_ref){
        return this.productService.getProductByRef(product_ref);
    }
    /**
     * This end-point allows to get products By category id
     * @param category_ref The category ref
     * @return list of products
     */
    @GetMapping("/category/{category_ref}")
    public List<ProductResponseDto> getProductsByCategory(@PathVariable UUID category_ref){
        return productService.getProductsByCategoryRef(category_ref);
    }
    /**
     * This end-point allows to get products By category id
     * @param category_id The category id
     * @return list of products
     */
    @GetMapping("/category/id/{category_id}")
    public List<ProductResponseDto> getProductsByCategory(@PathVariable Long category_id){
        return productService.getProductsByCategoryId(category_id);
    }
    

    /**
     * This end-point allows to save new Product
     * @return Created product
     */
    @PostMapping("")
    public Product savaProduct(@RequestParam("name") String name,
                               @RequestParam("price") String price,
                               @RequestParam("description") String description,
                               @RequestParam("ref") String ref,
                               @RequestParam("sku") String sku,
                               @RequestParam("categoryId") Long categoryId,
                               @RequestParam("sellerId") Long sellerId,
                               @RequestParam("img") List<MultipartFile> images){

        return productService.saveProduct( ProductDto.builder()
                .name(name)
                .img(images)
                .state(true)
                .sku(sku)
                .categoryId(categoryId)
                .sellerId(sellerId)
                .build());
    }

    @GetMapping("seller/{sellerId}")
    public List<ProductResponseDto> getProductsBySellerId(@PathVariable int sellerId){
        return this.productService.getProductsBySellerId(sellerId);
    }
}
