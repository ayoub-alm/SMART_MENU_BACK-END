package ma.smartMenu.smartmenu.repository;

import ma.smartMenu.smartmenu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
