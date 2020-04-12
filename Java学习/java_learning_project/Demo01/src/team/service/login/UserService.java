package team.service.login;

import team.dao.user.User;

public interface UserService {
	boolean confirmLogin(User user);
}
