package team.service.customer_service;

import java.util.List;

import team.dao.backupflow.BackupFlowDao;
import team.dao.backupflow.BackupFlowDaoImpl;
import team.dao.client.Client;
import team.dao.client.ClientDao;
import team.dao.client.ClientDaoImpl;
import team.dao.fix.FixDao;
import team.dao.fix.FixDaoImpl;
import team.dao.repair.Repair;
import team.dao.repair.RepairDao;
import team.dao.repair.RepairDaoImpl;
import team.dao.settlement.Settlement;
import team.dao.settlement.SettlementDao;
import team.dao.settlement.SettlementDaoImpl;
import team.utils.GetNowTime;

public class ClientServiceImpl implements ClientService{
	public static ClientServiceImpl instance = new ClientServiceImpl();
	
	
	public ClientServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ClientServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<String> getAllClients() {
		ClientDao clientDao = new ClientDaoImpl();
		return clientDao.getAllClients();
	}
	
	@Override
	public List<String> getClientByIDNumber(String ID_number) {
		ClientDao clientDao = new ClientDaoImpl();
		return clientDao.getClientByIDNumber(ID_number);
	}

	@Override
	public void insertClient(Client client) {
		ClientDao clientDao = new ClientDaoImpl();
		clientDao.insertClient(client);
	}

	@Override
	public boolean deleteClient(String ID_number) {
		ClientDao clientDao = new ClientDaoImpl();
		return clientDao.deleteClient(ID_number);
	}

	@Override
	public void updateClient(Client client) {
		ClientDao clientDao = new ClientDaoImpl();
		clientDao.updateClient(client);
	}

	@Override
	public String getNumberOfClient(String ID_number) {
		ClientDao clientDao = new ClientDaoImpl();
		return clientDao.getNumberOfClient(ID_number);
	}

	@Override
	public boolean insertRepair(Repair repair) {
		ClientDao clientDao = new ClientDaoImpl();
		boolean flag = clientDao.searchClientByNumber(repair.getclient_number());
		if (flag == false) return false;
		else {
			RepairDao repairDao = new RepairDaoImpl();
			repairDao.insertRepair(repair);
			return true;
		}
	}

	@Override
	public List<String> getAllFixs() {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.getAllFixs();
	}

	@Override
	public List<String> getFixByStatus3() {
		FixDao fixDao = new FixDaoImpl();
		return fixDao.getFixByStatus3();
	}

	@Override
	public void generateSettle(String number) {
		FixDao fixDao  = new FixDaoImpl();
		String workload = fixDao.getWorkload(number);
		int load = Integer.parseInt(workload) * 100;
		String fix_money = String.valueOf(load);
		System.out.println("fix_money:" + fix_money);
		BackupFlowDao backupFlowDao = new BackupFlowDaoImpl();
		int price = Integer.parseInt(backupFlowDao.getPrice(number));
		int amount = Integer.parseInt(backupFlowDao.getAmount(number));
		String material_money = String.valueOf(price * amount);
		System.out.println("material_money:" + material_money);
		String total_money = String.valueOf(price * amount + load);
		System.out.println("total_money: " + total_money);
		SettlementDao settlementDao = new SettlementDaoImpl();
		String settle_time = new GetNowTime().getNowTime();
		System.out.println("settle_time:" + settle_time);
		settlementDao.insertTmpSettle(new Settlement(number, fix_money, material_money, total_money, settle_time));
	}

	@Override
	public List<String> getTmpSettle() {
		SettlementDao settlementDao = new SettlementDaoImpl();
		return settlementDao.getTmpSettle();
	}

	@Override
	public void deleteTmpSettle(String fix_number) {
		SettlementDao settlementDao = new SettlementDaoImpl();
		settlementDao.deleteTmpSettle(fix_number);
	}

	@Override
	public void insertSettle(Settlement settlement) {
		// TODO Auto-generated method stub
		SettlementDao settlementDao = new SettlementDaoImpl();
		settlementDao.insertSettle(settlement);
	}

	@Override
	public void completeSettle(Settlement settlement) {
		SettlementDao settlementDao = new SettlementDaoImpl();
		settlementDao.deleteTmpSettle(settlement.getFix_number());
		settlementDao.insertSettle(settlement);
		
		FixDao fixDao = new FixDaoImpl();
		fixDao.deleteFix(settlement.getFix_number());
		
		RepairDao repairDao = new RepairDaoImpl();
		repairDao.deleteRepair(settlement.getFix_number());
	}

	@Override
	public List<String> getRepair() {
		RepairDao repairDao = new RepairDaoImpl();
		return repairDao.getRepair();
	}

	@Override
	public void submitFix(String number) {
		FixDao fixDao = new FixDaoImpl();
		fixDao.insertFix(number);
		
		RepairDao repairDao = new RepairDaoImpl();
		repairDao.updateStatusTo2(number);
	}
	
	
}
