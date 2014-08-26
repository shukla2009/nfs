package com.otentico.nfs;

import java.io.IOException;

import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.otentico.nfs.client.IHttpClient;
import com.otentico.nfs.clientImpl.RestClient;
import com.otentico.nfs.clientImpl.TestClient;
import com.otentico.nfs.model.Product;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void authenticateProduct(View view) {
		try {
			EditText nfsText = (EditText) findViewById(R.id.nfcText);
			String nfsId = nfsText.getText().toString();
			IHttpClient client = new TestClient(getAssets());
			// IHttpClient client = new RestClient();
			Product prod = client.getAuthenticatedProduct(nfsId);
			EditText result = (EditText) findViewById(R.id.resultText);
			if (prod != null) {
				result.setText(prod.toString());
			} else {
				result.setText("Not Authenticated");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
