package in.pritha;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;

import in.pritha.dto.UserDTO;
import in.pritha.model.Role;
import in.pritha.repository.RoleOneToManyUsers;

@SpringBootTest
class WeddingAppPaymentApiApplicationTests {

	@Autowired
	private RoleOneToManyUsers testRepository;

	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("One-to-Many Mapping Test")
	void contextLoads() {

		Role role = new Role();
		role.setId(3);
		role.setName("ADMIN");
		role.setDescription("one who purchase items");
		Set<UserDTO> users = new HashSet<>();
		users.add(getUser1());
		users.add(getUser2());
		role.setUsers(users);
		try {
			Role createdRole = testRepository.save(role);
			System.err.println("IsExecuted" + createdRole);
			boolean yes = createdRole != null;
			assertTrue(yes);
		} catch (IllegalArgumentException | IncorrectUpdateSemanticsDataAccessException
				| DbActionExecutionException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

	}

	private static UserDTO getUser1() {
		UserDTO userdto = new UserDTO();
		userdto.setUserId(300);
		userdto.setUserName("SUMATHI");
		userdto.setPassWord("SUMS@7172");
		userdto.setRole("USER");
		userdto.setMobileNumber(9789270465L);
		userdto.setDateRegistered(LocalDate.now());
		userdto.setUserActiveStatus("ACTIVE");

		System.out.println("user DTO" + userdto);

		return userdto;
	}

	private static UserDTO getUser2() {
		UserDTO user = new UserDTO();
		user.setUserId(400);
		user.setUserName("ABIRAMI");
		user.setMobileNumber(9789270465L);
		user.setPassWord("ABMS@7172");
		// user.setConfirmPassWord("SUMS@7172");
		user.setRole("USER");
		user.setDateRegistered(LocalDate.now());
		user.setUserActiveStatus("ACTIVE");

		return user;
	}

}
