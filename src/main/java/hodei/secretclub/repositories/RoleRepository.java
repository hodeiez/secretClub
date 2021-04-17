package hodei.secretclub.repositories;

import hodei.secretclub.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 22:33
 * Project: secretClub
 * Copyright: MIT
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
}
