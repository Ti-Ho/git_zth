package team.service.backupflow;

import java.util.List;

import team.dao.backup.BackupDao;
import team.dao.backup.BackupDaoImpl;
import team.dao.backupflow.BackupFlow;
import team.dao.backupflow.BackupFlowDao;
import team.dao.backupflow.BackupFlowDaoImpl;

public class BackupFlowServiceImpl implements BackupFlowService{
	private static BackupFlowServiceImpl instance = new BackupFlowServiceImpl();
	
	
	public BackupFlowServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static BackupFlowServiceImpl getInstance() {
		return instance;
	}


	@Override
	public int insertBackupFlow(String name, String type, String fixNumber, String amount, String outTime) {
		BackupDao backupDao = new BackupDaoImpl();
		int result = -1;
		boolean isExist = backupDao.searchBackup(name, type);
		System.out.println("从备件中查找的结果：" + isExist);
		if (isExist == false) {
			result = -1;
		} else {
			int old_amount = Integer.parseInt(backupDao.getAmountOfBackup(name, type));
			System.out.println("备件表中的数量：" + old_amount);
			int out_amount = Integer.parseInt(amount);
			System.out.println("出库的数量：" + out_amount);
			if (old_amount < out_amount) {
				result = 0;
			} else {
				BackupFlowDao backupFlowDao = new BackupFlowDaoImpl();
				String price = backupDao.getPriceOfBackup(name, type);
				System.out.println("备件的价格："+price);
				//插入备件流水表
				backupFlowDao.insertBackupFlow(new BackupFlow(name, type, fixNumber, amount, price, outTime));
				//更新备件表中的数量和状态
				int now_amount = old_amount - out_amount;
				String new_amount = String.valueOf(now_amount);
				String status = null;
				int now_deadline = Integer.parseInt(backupDao.getDeadlineOfBackup(name, type));
				if (now_amount > now_deadline) status = "正常";
				else if (now_amount == now_deadline) status = "临界";
				else if (now_amount > 0) status = "警示";
				else status = "缺货";
				System.out.println("备件的新数量：" + new_amount);
				System.out.println("备件的状态：" + status);
				//更新数量
				backupDao.updateAmountOfBackup(name, type, new_amount);
				//更新状态
				backupDao.updateStatusOfBackup(name, type, status);
				result = 1;
			}
		}
		return result;
	}

	@Override
	public List<BackupFlow> getAllBackupFlows() {
		BackupFlowDao backupFlowDao = new BackupFlowDaoImpl();
		return backupFlowDao.getAllBackupFlows();
	}


	
}
