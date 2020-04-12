package team.service.admin;

import java.util.List;

public interface AdminService {
	List<String> getAllUsers();
	List<String> getUserByRole(String role);
	void deleteUser(String account);
	void updateUser(String account, String password, String role);
	void addUser(String account, String password, String role);
}
