package hodei.secretclub.repositories;

import hodei.secretclub.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hodei Eceiza
 * Date: 4/18/2021
 * Time: 23:05
 * Project: secretClub
 * Copyright: MIT
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {
}
