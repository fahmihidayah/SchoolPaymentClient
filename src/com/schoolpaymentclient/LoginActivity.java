package com.schoolpaymentclient;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.http.Header;
import org.json.JSONObject;

import com.framework.file_handler.FileHandler;
import com.framework.rest_clients.MyRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Constantas;
import com.response.LoginResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity implements Constantas{

	@InjectView(R.id.editTextNim)
	EditText editTextNim;
	
	@OnClick(R.id.buttonLogin)
	public void onClickLogin(View view){
		RequestParams params = new RequestParams();
		params.put("nim", editTextNim.getText().toString());
		MyRestClient.post(API_LOGIN, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				LoginResponse loginResponse = new Gson().fromJson(response.toString(), LoginResponse.class);
				if(loginResponse != null){
					SchoolPaymentApp.getInstance().mahasiswaUser = loginResponse.getData();
					try {
						FileHandler.saveDataToFile(LoginActivity.this, MAHASISWA_USER, Context.MODE_PRIVATE, SchoolPaymentApp.getInstance().mahasiswaUser);
						startActivity(new Intent(LoginActivity.this, MainActivity.class));
						finish();
					} catch (FileNotFoundException e) {
						
					} catch (IOException e) {
						
					}
				}
				else {
					Toast.makeText(LoginActivity.this, "error login", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		ButterKnife.inject(this);
		if(SchoolPaymentApp.getInstance().mahasiswaUser != null){
			startActivity(new Intent(this, MainActivity.class));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
