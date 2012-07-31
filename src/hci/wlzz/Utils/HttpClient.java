package hci.wlzz.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

public class HttpClient {

	DefaultHttpClient httpClient = new DefaultHttpClient();;
	HttpResponse response;
	StringBuilder builder = new StringBuilder();

	// return JsonString
	public String sendHttpGet(String url) {

		HttpGet getRequest = new HttpGet(url);
		try {
			response = httpClient.execute(getRequest);
			InputStream inputStream = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				builder.append(s);
			}
			inputStream.close();
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}

	public String sendHttpPost(String url, List<NameValuePair> param) {

		HttpPost request = new HttpPost(url);

		try {
			request.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8));
			response = httpClient.execute(request);
			InputStream inputStream = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				builder.append(s);
			}
			inputStream.close();
			reader.close();

			// tested before
			/*
			 * JSONObject result = new JSONObject(builder.toString());
			 * JSONObject result = new JSONObject(EntityUtils.toString(response
			 * .getEntity())); JsonUtils ju = new JsonUtils();
			 * ju.parseJson(builder.toString()); test(builder.toString());
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();

	}
}
