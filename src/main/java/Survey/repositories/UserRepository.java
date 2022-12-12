package Survey.repositories;

import Survey.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
/*
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {

    Favorites findByUserIdAndItemId(int userId, int itemId);

    List<Favorites> findAllByUserId(int userId);

    Favorites findById(int id);

    Long deleteById(int id);

    @Transactional
    Long deleteAllByUserId(int userId);
}*/
