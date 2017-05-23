package upm.etsiinf.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upm.etsiinf.daw.model.User;

/**
 * Created by S on 14/05/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String user);
}