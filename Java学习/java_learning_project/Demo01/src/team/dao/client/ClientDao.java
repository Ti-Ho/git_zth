package team.dao.client;

import java.util.List;

public interface ClientDao {
	boolean searchClientByNumber(String number);
	List<String> getAllClients();
	List<String> getClientByIDNumber(String ID_number);
	boolean deleteClient(String ID_number);
	void insertClient(Client client);
	void updateClient(Client client);
	String getNumberOfClient(String ID_number);
}
