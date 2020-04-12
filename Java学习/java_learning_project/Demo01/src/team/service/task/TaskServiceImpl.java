package team.service.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.dao.fix.Fix;
import team.dao.fix.FixDao;
import team.dao.fix.FixDaoImpl;
import team.utils.DbUtils;

public class TaskServiceImpl implements TaskService{

	@Override
	public Fix searchTask(String number) {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.searchFix(number);
	}

	@Override
	public List<Fix> getAllTasks() {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.getAllFixsInTask();
	}

	@Override
	public void updateTask(String number, String fix_people) {
		FixDao fixDao = new FixDaoImpl();
		fixDao.updateFixInTask(number, fix_people);
	}

	@Override
	public void deleteTask(String number) {
		FixDao fixDao = new FixDaoImpl();
		fixDao.deleteFix(number);
	}

	@Override
	public Fix getTaskByNumber(String number) {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.getFixByNumber(number);
	}
	
}
