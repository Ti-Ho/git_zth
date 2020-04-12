package team.service.finance;

import java.util.List;

import team.dao.settlement.Settlement;
import team.dao.settlement.SettlementDao;
import team.dao.settlement.SettlementDaoImpl;

public class FinanceServiceImpl implements FinanceService{

	@Override
	public List<Settlement> getAllSettlement() {
		SettlementDao settlementdao = new SettlementDaoImpl();
		List<Settlement> list = settlementdao.getAllSettlement();
		return list;
	}

	@Override
	public List<Settlement> getSettlementByNumber(String Fix_number) {
		SettlementDao settlementdao = new SettlementDaoImpl();
		List<Settlement> list = settlementdao.getSettlementByNumber(Fix_number);
		return list;
	}

}
