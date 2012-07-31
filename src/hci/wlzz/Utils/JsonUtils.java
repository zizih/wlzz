package hci.wlzz.Utils;

import hci.wlzz.Model.User;
import com.google.gson.Gson;

public class JsonUtils {

	public void parseJson(String jsonString) {
		Gson gs = new Gson();
		System.out.println(jsonString);
		User user = gs.fromJson(jsonString, User.class);
		System.out.println("account= " + user.getAccount());
		System.out.println("passwd= " + user.getPasswd());
	}

	// public Class<?> parseJson(Class<?> cls, String json) {
	// Gson gson = new Gson();
	// Class<?> object = gson.fromJson(json, cls.getClass());
	// return object;
	// }
}
