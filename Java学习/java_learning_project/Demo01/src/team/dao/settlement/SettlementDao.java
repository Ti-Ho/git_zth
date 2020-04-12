package team.dao.settlement;

import java.util.List;

public interface SettlementDao {
	void insertSettle(Settlement settlement);
	void insertTmpSettle(Settlement settlement);
	List<String> getAllSettle();
	List<String> getTmpSettle();
	List<String> getSettleByNumber(String fix_number);
	void deleteTmpSettle(String fix_number);
	
	List<Settlement> getAllSettlement();
	List<Settlement> getSettlementByNumber(String Fix_number);
}
