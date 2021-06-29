package in.pritha.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import in.pritha.dto.UserDTO;
import in.pritha.model.BookingEntity;
import in.pritha.model.User;

public class ListToMapConvertor {
	
	
	//Using Java JDK8 Streams
		//List to Map conversion
		public static Map<String, String> listsToMap(List<UserDTO> allUsersList){
			Map<String, String> usersMap = new HashMap<>();
			usersMap = allUsersList.stream().collect(Collectors.toMap(UserDTO :: getUserName, UserDTO :: getPassWord));
			return usersMap;
			
		}

}
