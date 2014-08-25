package com.otentico.nfs.clientImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.otentico.nfs.client.IHttpClient;
import com.otentico.nfs.model.Product;
import com.otentico.nfs.util.NFSUtil;

public class TestClient implements IHttpClient {

	@Override
	public Product getAuthenticatedProduct(String nfsId) throws JSONException,
			IOException {
		// String dummyJSON =
		// "{\"products\": [{\"id\": \"1\",\"name\": \"product 1\"},{\"id\":\"2\",\"name\": \"product 2\"}}";
		StringBuffer sb = new StringBuffer();
		FileInputStream fIn = new FileInputStream(new File("db"));
		BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
		String line = "";
		while ((line = myReader.readLine()) != null) {
			sb.append(line);
		}
		myReader.close();
		JSONObject json = new JSONObject(sb.toString());
		JSONArray jsonArray = json.getJSONArray("products");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = (JSONObject) jsonArray.get(i);
			if (object.getString("id").equals(nfsId)) {
				Product product = new Product(object.getString("id"));
				product.setName(object.getString("name"));

				// TODO : set properties here

				return product;
			}
		}
		return null;
	}

}
