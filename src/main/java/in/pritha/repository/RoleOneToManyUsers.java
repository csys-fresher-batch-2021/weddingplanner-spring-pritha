package in.pritha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.pritha.model.Role;

@Repository
public interface RoleOneToManyUsers extends CrudRepository<Role, Integer> {

}
