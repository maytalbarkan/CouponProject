package Clients;
/**
 *this interface regulate the login methods-how to lgin the system and the client types of the system
 */
public interface Client 
{
	/**
	 * the enum ClientType describe which client types are available
	 */
	
	ClientType clientType = null;
	
	public Client login (String user, String password, ClientType clienttype);

}
