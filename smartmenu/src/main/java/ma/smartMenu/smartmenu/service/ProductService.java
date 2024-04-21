package ma.smartMenu.smartmenu.service;

import ma.smartMenu.smartmenu.dto.ProductDto;
import ma.smartMenu.smartmenu.dto.ProductImageSaveDto;
import ma.smartMenu.smartmenu.dto.ProductResponseDto;
import ma.smartMenu.smartmenu.model.Product;
import ma.smartMenu.smartmenu.model.ProductCategory;
import ma.smartMenu.smartmenu.model.ProductImage;
import ma.smartMenu.smartmenu.model.Seller;
import ma.smartMenu.smartmenu.repository.ProductCategoryRepository;
import ma.smartMenu.smartmenu.repository.ProductRepository;
import ma.smartMenu.smartmenu.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ProductImageService productImageService;

    /**
     * This function allows us to get all products
     * @return {List<ProductResponseDto>} list of products
     */
    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    /**
     * This function allows us to get product by id
     * @param id the product id
     * @return {Optional<Product>} selected product
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * This function allows us to save new product
     * @param productDto info to create the product
     * @return {Product} Saved product
     */
    public Product saveProduct(ProductDto productDto) {
        // Get seller
        Optional<Seller> seller = sellerRepository.findById(productDto.getSellerId());
        // Get the category
        ProductCategory category = productCategoryRepository.getReferenceById(productDto.categoryId);

        // Save product and return saved product
        Product savedProduct = productRepository.save(Product.builder()
                        .name(productDto.name)
                        .sku(productDto.sku)
                        .ref(UUID.randomUUID())
                        .category(category)
                        .seller(seller.get())
                        .description(productDto.description)
                        .price(productDto.price)
                        .state(true)
                .build()
        );
        List<ProductImageSaveDto> images = new ArrayList<ProductImageSaveDto>();
        // Construct ProductImageSaveDto objects
       images.add(ProductImageSaveDto.builder()
                        .productId(savedProduct.getId())
                        .img(productDto.getImg())
                        .build());
        // Save images locally and get paths names
        List<ProductImage> savedProductImages = this.productImageService.saveProductImages(images);
        // Handle savedProductImages if needed

        return savedProduct;
    }

    /**
     * This Function allows us to get list of products by category_id
     * @param category_ref The category ref
     * @return List of products
     */
     public List<ProductResponseDto> getProductsByCategoryRef(UUID category_ref){
        List<Product> products = this.productRepository.findByCategory_Ref(category_ref);
        return products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    /**
     * This function allows us to get list of products by seller ID
     * @param sellerId The seller ID
     * @return {List<ProductResponseDto>} List of products
     */
    public List<ProductResponseDto> getProductsBySellerId(int sellerId){
        List<Product> products = this.productRepository.findBySeller_id(sellerId);

        return  products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    /**
     * This function allow us to get product by ref
     * @param productRef The product Reference
     * @return {ProductResponseDto}
     */
    public Optional<ProductResponseDto> getProductByRef(UUID productRef) {
      Optional<Product> product = this.productRepository.findByRef(productRef);
      return product.map(ProductResponseDto::new);
    }
}