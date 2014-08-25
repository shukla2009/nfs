package com.otentico.nfs.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;

import com.otentico.nfs.model.Product;

public interface IHttpClient {
	Product getAuthenticatedProduct(String id) throws JSONException,
			IOException;
}
