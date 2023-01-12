package dao;
import java.sql.SQLException;

import Models.Client;
import javafx.collections.ObservableList;


public interface ClientDao {
	public ObservableList<Client> getAllClients()throws SQLException;
	public void addClient(Client clt)throws SQLException;
	public void updateClient(Client clt)throws SQLException;
	public void deleteClient(Client clt)throws SQLException;
}
