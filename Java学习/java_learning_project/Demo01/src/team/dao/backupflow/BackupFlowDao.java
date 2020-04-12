package team.dao.backupflow;

import java.util.List;

public interface BackupFlowDao {
	void insertBackupFlow(BackupFlow backupFlow);
	List<BackupFlow> getAllBackupFlows();
	String getPrice(String fix_number);
	String getAmount(String fix_number);
	
}
