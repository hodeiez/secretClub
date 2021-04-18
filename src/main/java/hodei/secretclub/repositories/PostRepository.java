package hodei.secretclub.repositories;

import hodei.secretclub.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hodei Eceiza
 * Date: 4/18/2021
 * Time: 23:04
 * Project: secretClub
 * Copyright: MIT
 */
public interface PostRepository extends JpaRepository<Post,Integer> {
}
