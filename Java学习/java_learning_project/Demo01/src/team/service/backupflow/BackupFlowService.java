package team.service.backupflow;

import java.util.List;

import team.dao.backupflow.BackupFlow;

public interface BackupFlowService {
	int insertBackupFlow(String name, String type, String fixNumber, String amount, String outTime);
	List<BackupFlow> getAllBackupFlows();
}
