package mail.UserManager;

import java.util.List;

import com.springmvc.user.UserInfo;

public interface UserManager {
	
	//This will add the email user into the database
	public int add(UserInfo u);
	
	//It will be a password recovery method
	public int recoverPassword(UserInfo u);
	
	//This will be remove user option
	public boolean removeUser(UserInfo u);
	
	/*This method will will fetch the list of contacts for a specific user*/
	public List<String> contacts(UserInfo u);
	
	/*This method will check if user is registered or not*/
	public boolean check(String user, String pass);

}
