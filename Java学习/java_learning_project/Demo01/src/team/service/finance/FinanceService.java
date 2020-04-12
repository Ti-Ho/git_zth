package team.service.finance;

import java.util.List;

import team.dao.settlement.Settlement;

public interface FinanceService {
	List<Settlement> getAllSettlement();
	List<Settlement> getSettlementByNumber(String Fix_number);
}
