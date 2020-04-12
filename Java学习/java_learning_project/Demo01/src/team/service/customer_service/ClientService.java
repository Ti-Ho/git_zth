package team.service.customer_service;

import java.util.List;

import team.dao.client.Client;
import team.dao.repair.Repair;
import team.dao.settlement.Settlement;

public interface ClientService {
	List<String> getAllClients();
	List<String> getClientByIDNumber(String ID_number);
	void insertClient(Client client);
	boolean deleteClient(String ID_number);
	void updateClient(Client client);
	String getNumberOfClient(String ID_number);
	boolean insertRepair(Repair repair);
	List<String> getAllFixs();
	List<String> getFixByStatus3();
	void generateSettle(String number);
	List<String> getTmpSettle();
	void deleteTmpSettle(String fix_number);
	
	void insertSettle(Settlement settlement);
	
	void completeSettle(Settlement settlement);
	
	List<String> getRepair();
	
	void submitFix(String number);
}
