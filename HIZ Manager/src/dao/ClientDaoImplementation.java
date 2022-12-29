package dao;

import java.util.ArrayList;
import java.util.List;

import Models.Client;


public class ClientDaoImplementation implements ClientDao{
	static List<Client> Clients;
	{
	Clients= new ArrayList<>();
	Clients.add(new Client("E144436",1,"hsina@gmail.com","timo","0665655628"));
	Clients.add(new Client("E121536",2,"ha@gmail.com","Bogh","0666555628"));
	Clients.add(new Client("E123536",3,"hnjhba@gmail.com","Hssina","0666555628"));
	Clients.add(new Client("E123533",4,"kjnfia@gmail.com","ygv","0666555628"));
	Clients.add(new Client("E124631",5,"hnjknfia@gmail.com","zazzz","0664455628"));
	Clients.add(new Client("E124436",6,"hbhia@gmail.com","Hfifisa","0666555628"));
	}
	@Override
	public  List<Client> getAllClients() {
	
		return Clients;
	}

	public static List<Client> getClients() {
		return Clients;
	}

	@Override
	public void addClient(Client clt) {
		Clients.add(clt);
		
		System.out.println("Client Added " + Clients.size());
	}
	

}
