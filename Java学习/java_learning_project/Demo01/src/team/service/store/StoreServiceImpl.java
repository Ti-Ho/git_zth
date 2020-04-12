package team.service.store;

import java.util.List;

import team.dao.backup.Backup;
import team.dao.backup.BackupDao;
import team.dao.backup.BackupDaoImpl;

public class StoreServiceImpl implements StoreService{

	private static StoreServiceImpl instance = new StoreServiceImpl();
	
	public StoreServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void inStore(Backup backup) {
		BackupDao backupDao = new BackupDaoImpl();
		boolean flag = backupDao.searchBackup(backup.getName(), backup.getType());
		System.out.println("serach result: " + flag);
		if (flag == true) { //已存在
			int old_amount = Integer.parseInt(backupDao.getAmountOfBackup(backup.getName(), backup.getType()));
			int delt_amount = Integer.parseInt(backup.getAmount());
			String new_amount = String.valueOf(old_amount + delt_amount);
			int now_amount = Integer.parseInt(new_amount);
			int now_deadline = Integer.parseInt(backupDao.getDeadlineOfBackup(backup.getName(), backup.getType()));
			String status = null;
			if (now_amount > now_deadline) status = "正常";
			else if (now_amount == now_deadline) status = "临界";
			else if (now_amount > 0) status = "警示";
			else status = "缺货";
			backupDao.updateAmountOfBackup(backup.getName(), backup.getType(), new_amount);
			backupDao.updateStatusOfBackup(backup.getName(), backup.getType(), status);
		} else { //不存在
			backupDao.insertBackup(backup);
		}
	}
	
	public static StoreServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<Backup> getAllBackups() {
		BackupDao backupDao = new BackupDaoImpl();
		return backupDao.getAllBackups();
	}

	@Override
	public List<Backup> getBackupsByNameAndType(String name, String type) {
		BackupDao backupDao = new BackupDaoImpl();
		return backupDao.getBackupsByNameAndType(name, type);
	}

	@Override
	public String getAmountOfBackup(String name, String type) {
		BackupDao backupDap = new BackupDaoImpl();
		return backupDap.getAmountOfBackup(name, type);
	}

	@Override
	public String getDeadlineOfBackup(String name, String type) {
		BackupDao backupDao = new BackupDaoImpl();
		return backupDao.getDeadlineOfBackup(name, type);
	}

	@Override
	public void updateAmountOfBackup(String name, String type, String amount) {
		BackupDao backupDao = new BackupDaoImpl();
		backupDao.updateAmountOfBackup(name, type, amount);
	}

	@Override
	public void updateStatusOfBackup(String name, String type, String status) {
		BackupDao backupDao = new BackupDaoImpl();
		backupDao.updateStatusOfBackup(name, type, status);
	}

}
