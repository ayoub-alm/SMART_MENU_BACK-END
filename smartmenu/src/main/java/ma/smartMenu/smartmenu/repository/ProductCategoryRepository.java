package ma.smartMenu.smartmenu.repository;

import ma.smartMenu.smartmenu.model.Product;
import ma.smartMenu.smartmenu.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
