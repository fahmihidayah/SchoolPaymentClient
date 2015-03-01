package com.schoolpaymentclient;

import com.framework.image_handler.CropImageHandler;
import com.framework.rest_clients.MyRestClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Constantas;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements Constantas{

	@InjectView(R.id.textViewInfo)
	TextView textViewInfo;
	
	CropImageHandler cropImageHandler;
	
	@OnClick(R.id.buttonDataNotif)
	public void onClickNotif(View view){
		
	}
	
	@OnClick(R.id.buttonPesanAdmin)
	public void onClickPesan(View view){
		startActivity(new Intent(MainActivity.this, PesanActivity.class));
	}
	
	@OnClick(R.id.buttonRegistrasi)
	public void onClickRegistrasi(View view){
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		ButterKnife.inject(this);
		String infoMahasiswa = "NIM : " + SchoolPaymentApp.getInstance().mahasiswaUser.getNim() + "\n";
		infoMahasiswa += "Nama : " + SchoolPaymentApp.getInstance().mahasiswaUser.getNama() + "\n";
		infoMahasiswa += "Alamat : " + SchoolPaymentApp.getInstance().mahasiswaUser.getAlamat() + "\n";
		infoMahasiswa += "Telepon : " + SchoolPaymentApp.getInstance().mahasiswaUser.getTelepon() + "\n";
		textViewInfo.setText(infoMahasiswa);
		cropImageHandler = new CropImageHandler(this);
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
