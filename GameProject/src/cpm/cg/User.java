package cpm.cg;

import java.util.HashMap;
import java.util.Map;

public class User implements IValidate {
	private String userid;
	private String password;
	Map<String, String> users=new HashMap<String,String>();
	public void addUser(String userid, String password) {
		users.put(userid, password);
	}

	@Override
	public boolean IsAuthenticated(String userid, String password) {
		if(users.containsKey(userid)) {
			if(users.get(userid).equals(password)) {
				return true;
			}			
		} 
		return false;
		//return (this.userid.equals(userid) && this.password.equals(password));
	}

}
