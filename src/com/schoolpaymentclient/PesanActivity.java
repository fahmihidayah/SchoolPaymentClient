package com.schoolpaymentclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONObject;

import com.framework.adapter.CustomAdapter;
import com.framework.common_utilities.ViewSetterUtilities;
import com.framework.rest_clients.MyRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Constantas;
import com.models.Pesan;
import com.response.ListPesanResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class PesanActivity extends ActionBarActivity implements Constantas{

	@InjectView(R.id.listViewPesan)
	ListView listViewPesan;
	
	CustomAdapter<Pesan> customAdapter;
	
	List<Pesan> listPesans = new ArrayList<Pesan>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pesan_activity);
		ButterKnife.inject(this);
		customAdapter = new CustomAdapter<Pesan>(this,R.layout.item_pesan_layout , listPesans) {
			
			@Override
			public void setViewItems(View view, Pesan data) {
				ViewSetterUtilities.setTextToView(view, R.id.textViewPesan, data.getData_pesan());
			}
		};
		listViewPesan.setAdapter(customAdapter);
		requestListPesan();
	}

	public void requestListPesan(){
		RequestParams params = new RequestParams();
		params.put("mahasiswas_id", SchoolPaymentApp.getInstance().mahasiswaUser.getId());
		MyRestClient.post(API_PESAN, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				ListPesanResponse listPesanResponse = new Gson().fromJson(response.toString(), ListPesanResponse.class);
				listPesans.addAll(listPesanResponse.getData());
				customAdapter.notifyDataSetChanged();
			}
		});
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
