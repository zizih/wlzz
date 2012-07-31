package hci.wlzz.UI;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import hci.wlzz.Utils.HttpClient;
import hci.wlzz.Utils.JsonUtils;
import hci.wlzz.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	EditText account, passwd;
	Button submit;

	String baseUrl = "http://172.26.14.209:9001/test";
	HttpClient httpClient = new HttpClient();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		account = (EditText) findViewById(R.id.account);
		passwd = (EditText) findViewById(R.id.passwd);
		submit = (Button) findViewById(R.id.submit);

		submit.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*
				 * String url = baseUrl + "?account=" +
				 * account.getText().toString() + "&passwd=" +
				 * passwd.getText().toString(); JsonUtils ju = new JsonUtils();
				 * ju.parseJson(httpClient.sendHttpGet(url));
				 */

				// use for test
				/*
				 * JSONObject jo; try { jo = new
				 * JSONObject(httpClient.sendHttpGet(url));
				 * System.out.println("account = " + jo.getString("account")); }
				 * catch (Exception e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */

				List<NameValuePair> param = new ArrayList<NameValuePair>();
				param.add(new BasicNameValuePair("account", account.getText()
						.toString()));
				param.add(new BasicNameValuePair("passwd", passwd.getText()
						.toString()));
				JsonUtils ju = new JsonUtils();
				ju.parseJson(httpClient.sendHttpPost(baseUrl, param));
			}

		});

	}
}
