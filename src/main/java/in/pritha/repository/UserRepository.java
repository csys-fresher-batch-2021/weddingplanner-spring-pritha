package in.pritha.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.pritha.dto.UserDTO;


@Repository
public interface UserRepository extends CrudRepository<UserDTO, Integer>  {
	
}


