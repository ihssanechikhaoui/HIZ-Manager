package dao;
import java.util.List;
import Models.Client;


public interface ClientDao {
	public List<Client> getAllClients();
	public void addClient(Client clt);
	
	
}
