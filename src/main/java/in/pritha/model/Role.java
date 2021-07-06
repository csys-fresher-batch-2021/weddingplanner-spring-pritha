package in.pritha.model;

import java.util.Set;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import in.pritha.dto.UserDTO;
import lombok.Data;

@Data
@Table("roles")
public class Role {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String description;

	// one-to-many
	@MappedCollection(keyColumn = "role_id", idColumn = "role_id")
	private Set<UserDTO> users;

}
