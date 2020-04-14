package sii.maroc.CQRS_training_v1;

import org.springframework.data.repository.CrudRepository;
import sii.maroc.CQRS_training_v1.entities.AccountQueryEntity;

public interface AccountRepository extends CrudRepository<AccountQueryEntity,String> {
}
