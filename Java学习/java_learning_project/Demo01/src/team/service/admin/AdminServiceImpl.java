package team.service.admin;

import java.util.List;

import team.dao.user.UserDao;
import team.dao.user.UserDaoImpl;

public class AdminServiceImpl implements AdminService{
	private static AdminServiceImpl instance = new AdminServiceImpl();

	public AdminServiceImpl() {
		super();
	}

	public static AdminServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<String> getAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.getAllUsers();
	}

	@Override
	public List<String> getUserByRole(String role) {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUserByRole(role);
	}

	@Override
	public void deleteUser(String account) {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(account);
	}

	@Override
	public void updateUser(String account, String password, String role) {
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(account, password, role);
	}

	@Override
	public void addUser(String account, String password, String role) {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(account, password, role);
	}
	
	
}
