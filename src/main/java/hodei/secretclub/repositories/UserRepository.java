package hodei.secretclub.repositories;

import hodei.secretclub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 22:32
 * Project: secretClub
 * Copyright: MIT
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
