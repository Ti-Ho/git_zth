package team.service.store;

import java.util.List;

import team.dao.backup.Backup;

public interface StoreService {
	List<Backup> getAllBackups();
	List<Backup> getBackupsByNameAndType(String name, String type);
	String getAmountOfBackup(String name, String type);
	String getDeadlineOfBackup(String name, String type);
	void updateAmountOfBackup(String name, String type, String amount);
	void updateStatusOfBackup(String name, String type, String status);
	void inStore(Backup backup);
}
