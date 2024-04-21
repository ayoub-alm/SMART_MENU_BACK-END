package ma.smartMenu.smartmenu.repository;

import ma.smartMenu.smartmenu.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
