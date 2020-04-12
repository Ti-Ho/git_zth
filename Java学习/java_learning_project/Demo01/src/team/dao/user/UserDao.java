package team.dao.user;

import java.util.List;

public interface UserDao {
	List<String> getAllUsers();
	List<String> getUserByRole(String role);
	void deleteUser(String account);
	void updateUser(String account, String password, String role);
	void addUser(String account, String password, String role);
	
	boolean searchUser(User user);
}
