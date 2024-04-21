package ma.smartMenu.smartmenu.service;

import ma.smartMenu.smartmenu.dto.ProductImageResponseDto;
import ma.smartMenu.smartmenu.dto.ProductImageSaveDto;
import ma.smartMenu.smartmenu.model.ProductImage;
import ma.smartMenu.smartmenu.repository.ProductImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductImageService {

    private String uploadDir  = "./";
    private ProductImageRepository productImageRepository;
    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    /**
     * This function allows to get all images of a product by giving product id
     * @param productId The ID of Product
     * @return {List<ProductImageResponseDto>}  List of images
     */
    List<ProductImageResponseDto> getImagesByProductId(Long productId){
        return this.productImageRepository.findByProductId(productId);
    }

    /**
     *
     * @param productImageSaveDtos
     * @return
     */
    public List<ProductImage> saveProductImages(List<ProductImageSaveDto> productImageSaveDtos) {
        List<ProductImage> savedProductImages = new ArrayList<>();
        // Store images and get Path

        productImageSaveDtos.forEach(productImageSaveDto -> {
            List<ProductImage> images = productImageSaveDto.getImg().stream().map(multipartFile -> {
                try {
                    return this.productImageRepository.save(ProductImage.builder()
                            .path(this.storeFile(multipartFile))
                            .name(multipartFile.getName())
                            .productId(productImageSaveDto.getProductId())
                            .extension(multipartFile.getContentType())
                            .build());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
            savedProductImages.addAll(images);
        });
        return savedProductImages;
    }


    /**
     * This Function allows us to store image locally
     * @param file File to store
     * @return File path
     * @throws IOException
     */
    public String storeFile(MultipartFile file) throws IOException {
        // Generate a unique file name
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // Resolve the file path
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

        // Copy the file to the target location
        Files.copy(file.getInputStream(), filePath);

        return filePath.toString();
    }
}
