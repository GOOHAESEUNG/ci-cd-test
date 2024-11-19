package groom.buddy.checkList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends CrudRepository<CheckList, Long> {
}
