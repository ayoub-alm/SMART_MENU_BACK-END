package ma.smartMenu.smartmenu.repository;

import ma.smartMenu.smartmenu.dto.ProductImageResponseDto;
import ma.smartMenu.smartmenu.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImageResponseDto> findByProductId(Long productId);
}
