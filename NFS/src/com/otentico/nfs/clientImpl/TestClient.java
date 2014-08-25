package com.otentico.nfs.clientImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetManager;

import com.otentico.nfs.client.IHttpClient;
import com.otentico.nfs.model.Product;

public class TestClient implements IHttpClient {

	private final AssetManager assets;

	public TestClient(AssetManager assets) {
		this.assets = assets;
	}

	@Override
	public Product getAuthenticatedProduct(String nfsId) throws JSONException,
			IOException {
		JSONObject json = new JSONObject(readAssetsFile().trim());
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

	private String readAssetsFile() throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				assets.open("input.json")));
		String temp;
		while ((temp = br.readLine()) != null)
			sb.append(temp);
		br.close();
		return sb.toString();

	}

}
