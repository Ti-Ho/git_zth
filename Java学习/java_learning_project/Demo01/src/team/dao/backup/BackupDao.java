package team.dao.backup;

import java.util.List;

public interface BackupDao {
	List<Backup> getAllBackups();
	List<Backup> getBackupsByNameAndType(String name, String type);
	String getAmountOfBackup(String name, String type);
	String getDeadlineOfBackup(String name, String type);
	String getPriceOfBackup(String name, String type);
	void updateAmountOfBackup(String name, String type, String amount);
	void updateStatusOfBackup(String name, String type, String status);
	void insertBackup(Backup backup);
	boolean searchBackup(String name, String type);
}
