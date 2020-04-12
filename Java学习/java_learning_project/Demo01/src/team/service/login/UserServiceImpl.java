package team.service.login;

import team.dao.user.User;
import team.dao.user.UserDao;
import team.dao.user.UserDaoImpl;

public class UserServiceImpl implements UserService{
	private static UserServiceImpl instance = new UserServiceImpl();
	
	public static UserServiceImpl getInstance() {
		return instance;
	}

	@Override
	public boolean confirmLogin(User user) {
		UserDao userDao = new UserDaoImpl();
		boolean flag = userDao.searchUser(user);
		return flag;
	}
	
}
