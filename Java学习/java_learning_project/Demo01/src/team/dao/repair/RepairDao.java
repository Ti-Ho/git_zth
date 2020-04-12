package team.dao.repair;

import java.util.List;

public interface RepairDao {
	void insertRepair(Repair repair);
	void deleteRepair(String number);
	List<String> getRepair();
	
	void updateStatusTo2(String number);
}
