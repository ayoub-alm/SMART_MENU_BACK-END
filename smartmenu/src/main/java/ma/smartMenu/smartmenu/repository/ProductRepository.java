package ma.smartMenu.smartmenu.repository;

import ma.smartMenu.smartmenu.dto.ProductResponseDto;
import ma.smartMenu.smartmenu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    // Custom query method to find products by category ID
    List<Product> findByCategory_Ref(UUID categoryRef);

    List<Product> findBySeller_id(int sellerId);

    Optional<Product> findByRef(UUID productRef);
}