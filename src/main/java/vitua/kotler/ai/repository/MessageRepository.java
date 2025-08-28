package vitua.kotler.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitua.kotler.ai.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
